package com.movisens.smartgattlib.security;

import sun.security.util.ByteArrays;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil
{

    public static void main(String[] args) {

        byte[] keydata = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6};

        SecretKey key = createAesKey(keydata);
        byte[] chiperText = encrypt("1234567890123456".getBytes(StandardCharsets.UTF_8), key);

        for(int i=0;i<chiperText.length;i++){
            System.out.format("%02x ", chiperText[i]);
        }
        System.out.println();
        System.out.println(chiperText);
    }

    public static SecretKey createAesKey(String password)
    {
        try
        {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), password.getBytes(), 65536, 128);
            SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
            return secret;
        }
        catch (Throwable t)
        {
            throw new RuntimeException(t.getMessage());
        }
    }

    public static SecretKey createAesKey(byte[] aesKey)
    {
        try
        {
            SecretKey secret = new SecretKeySpec(aesKey, "AES");
            return secret;
        }
        catch (Throwable t)
        {
            throw new RuntimeException(t.getMessage());
        }
    }

    public static byte[] encrypt(byte[] input, SecretKey key)
    {
        if (input.length % 16 == 0)
        {
            return encryptBlocks(input, key);
        }
        else if (input.length < 16)
        {
            byte[] d = new byte[16];
            Arrays.fill(d, (byte) 0);
            System.arraycopy(input, 0, d, 0, input.length);
            return encryptBlocks(d, key);
        }
        else if (input.length > 16 && input.length < 32)
        {
            return encryptCtsTail(input, key);
        }
        else
        {
            throw new RuntimeException("input len not supported");
        }
    }

    public static byte[] decrypt(byte[] input, SecretKey key)
    {
        if (input.length % 16 == 0)
        {
            return decryptBlocks(input, key);
        }
        else if (input.length > 16 && input.length < 32)
        {
            return decryptCtsTail(input, key);
        }
        else
        {
            throw new RuntimeException("input len not supported");
        }
    }

    public static byte[] encryptCtsTail(byte[] plainText, SecretKey key)
    {
        // ciphertext stealing (CTS)

        // input.length 17 .. 31

        byte[] b1 = Arrays.copyOfRange(plainText, 0, 16);
        byte[] c1 = encryptBlocks(b1, key);

        byte[] b2 = new byte[16];
        System.arraycopy(plainText, 16, b2, 0, plainText.length - 16);
        System.arraycopy(c1, plainText.length - 16, b2, plainText.length - 16, 32 - plainText.length);
        byte[] c2 = encryptBlocks(b2, key);

        byte[] cipherText = new byte[plainText.length];
        System.arraycopy(c1, 0, cipherText, 0, plainText.length - 16);
        System.arraycopy(c2, 0, cipherText, plainText.length - 16, 16);

        return cipherText;
    }

    public static byte[] decryptCtsTail(byte[] cipherText, SecretKey key)
    {
        // ciphertext stealing (CTS)

        // input.length 17 .. 31

        byte[] b1 = Arrays.copyOfRange(cipherText, cipherText.length - 16, cipherText.length);
        byte[] c1 = decryptBlocks(b1, key);

        byte[] b2 = new byte[16];
        System.arraycopy(cipherText, 0, b2, 0, cipherText.length - 16);
        System.arraycopy(c1, cipherText.length - 16, b2, cipherText.length - 16, 32 - cipherText.length);
        byte[] c2 = decryptBlocks(b2, key);

        byte[] plainText = new byte[cipherText.length];
        System.arraycopy(c1, 0, plainText, 16, cipherText.length - 16);
        System.arraycopy(c2, 0, plainText, 0, 16);

        return plainText;
    }

    public static byte[] encryptBlocks(byte[] input, SecretKey key)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(input);
        }
        catch (Throwable e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static byte[] decryptBlocks(byte[] cipherText, SecretKey key)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(cipherText);
        }
        catch (Throwable e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

}
