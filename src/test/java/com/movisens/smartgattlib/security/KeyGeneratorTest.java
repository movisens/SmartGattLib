package com.movisens.smartgattlib.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.security.spec.InvalidKeySpecException;
import java.text.Normalizer;

import org.junit.Test;

public class KeyGeneratorTest
{
    @Test
    public void isDeterministicForSamePassword() throws Exception
    {
        long a = KeyGenerator.createKey("Tr0ub4dor&3");
        long b = KeyGenerator.createKey("Tr0ub4dor&3");
        assertEquals(a, b);
    }

    @Test
    public void matchesLegacyUsbPasswordOnlyDerivation() throws Exception
    {
        assertEquals(6217925914105931191L, KeyGenerator.createKey("Tr0ub4dor&3"));
    }

    @Test
    public void differentPasswordsGiveDifferentKeys() throws Exception
    {
        long a = KeyGenerator.createKey("correct horse");
        long b = KeyGenerator.createKey("wrong horse");
        assertNotEquals(a, b);
    }

    @Test
    public void passwordIsNfcNormalised() throws Exception
    {
        // Same text "cafe"+e-acute in two Unicode forms, built from numeric code points so the
        // source stays pure ASCII and nothing can silently normalise the literals:
        //   NFC: precomposed e-acute U+00E9   |   NFD: plain "e" + combining acute U+0301
        String nfc = "caf" + (char) 0x00E9;
        String nfd = "cafe" + (char) 0x0301;
        assertNotEquals("precondition: the two forms differ as raw strings", nfc, nfd);
        assertEquals(Normalizer.normalize(nfc, Normalizer.Form.NFC), Normalizer.normalize(nfd, Normalizer.Form.NFC));
        assertEquals(KeyGenerator.createKey(nfc), KeyGenerator.createKey(nfd));
    }

    @Test(expected = InvalidKeySpecException.class)
    public void rejectsEmptyPassword() throws Exception
    {
        KeyGenerator.createKey("");
    }
}
