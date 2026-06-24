package com.movisens.smartgattlib.security;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.Normalizer;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.movisens.smartgattlib.helper.GattByteBuffer;

/**
 * The single source of truth for the 64-bit seal/login key, used by BLE
 * (SealSensor / SPAKE secret) and the USB sensor interface alike. Cross-transport
 * sealing requires the same password to yield the same key, so this derivation
 * must not diverge between transports.
 *
 * <p>Derivation: PBKDF2-HMAC-SHA256 over the NFC-normalised, UTF-8 encoded password,
 * using the same password bytes as salt. JDK only (Android-compatible) - no
 * BouncyCastle / native.</p>
 *
 * <p>The key is 64 bit because the USB protocol ({@code sealSensor(int64_t)}) and BLE
 * must carry the same value. Those 8 bytes are also the SPAKE2 {@code secret}
 * ({@code w = SHA-256(8 bytes) mod n}).</p>
 */
public class KeyGenerator
{
    /**
     * PBKDF2 iteration count. Fixed: it is part of the cross-transport contract
     * and matches the legacy USB sensor-interface derivation.
     */
    private static final int ITERATIONS = 65_536;

    /** Legacy USB derives 128 bit and uses the first 64 bit as protocol key. */
    private static final int KEY_LENGTH_BITS = 128;

    /**
     * Derives the 64-bit seal/login key from the sealing password.
     *
     * @param password the user sealing password (any Unicode; NFC-normalised internally)
     */
    public static long createKey(String password)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        if (password == null)
        {
            throw new InvalidKeySpecException("password is required for key derivation");
        }
        String normalized = Normalizer.normalize(password, Normalizer.Form.NFC);
        if (normalized.isEmpty())
        {
            throw new InvalidKeySpecException("password must not be empty");
        }
        byte[] salt = normalized.getBytes(StandardCharsets.UTF_8);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(normalized.toCharArray(), salt, ITERATIONS, KEY_LENGTH_BITS);
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();

        return GattByteBuffer.wrap(keyBytes).getInt64();
    }
}
