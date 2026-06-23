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
 * sealing requires the same {@code (password, serial)} to yield the same key, so this
 * derivation must not diverge between transports.
 *
 * <p>Derivation: PBKDF2-HMAC-SHA256 over the NFC-normalised, UTF-8 encoded password,
 * with the sensor serial as the salt and a high, fixed iteration count. JDK only
 * (Android-compatible) — no BouncyCastle / native.</p>
 *
 * <p>The key is 64 bit because the USB protocol ({@code sealSensor(int64_t)}) and BLE
 * must carry the same value. Those 8 bytes are also the SPAKE2 {@code secret}
 * ({@code w = SHA-256(8 bytes) mod n}).</p>
 */
public class KeyGenerator
{
    /**
     * PBKDF2 iteration count. High by design (OWASP-range) to slow brute force against
     * the low-entropy sealing password. Fixed: it is part of the cross-transport contract.
     */
    private static final int ITERATIONS = 600_000;

    /** Derived key length in bits (64 bit -> 8 bytes -> {@code long}). */
    private static final int KEY_LENGTH_BITS = 64;

    /**
     * Derives the 64-bit seal/login key from the sealing password and the sensor serial.
     *
     * @param password the user sealing password (any Unicode; NFC-normalised internally)
     * @param serial   the sensor serial number; used as the PBKDF2 salt (UTF-8 bytes)
     */
    public static long createKey(String password, String serial)
        throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String normalized = Normalizer.normalize(password, Normalizer.Form.NFC);
        byte[] salt = serial.getBytes(StandardCharsets.UTF_8);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(normalized.toCharArray(), salt, ITERATIONS, KEY_LENGTH_BITS);
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();

        return GattByteBuffer.wrap(keyBytes).getInt64();
    }
}
