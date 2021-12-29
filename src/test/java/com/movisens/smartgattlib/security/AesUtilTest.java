package com.movisens.smartgattlib.security;

import static org.junit.Assert.assertEquals;

import javax.crypto.SecretKey;

import org.junit.Test;


public class AesUtilTest
{
    static SecretKey key = AesUtil.createAesKey("secret");
    
    @Test
    public void testSmallBlock()
    {
        String plainText = "abcdefgh";
        
        byte[] ciperText = AesUtil.encrypt(plainText.getBytes(), key);
        assertEquals(16, ciperText.length);
        
        byte[] resultText = AesUtil.decrypt(ciperText, key);
        String resultString = new String(resultText, 0, plainText.length());
        assertEquals(plainText, resultString);     
    }

    @Test
    public void testMultibleOf16k()
    {
        String plainText = "123456781234567812345678123456781234567812345678";
        
        byte[] ciperText = AesUtil.encrypt(plainText.getBytes(), key);
        assertEquals(plainText.length(), ciperText.length);
        
        byte[] resultText = AesUtil.decrypt(ciperText, key);
        String resultString = new String(resultText, 0, plainText.length());
        assertEquals(plainText, resultString);     
    }

    @Test
    public void testLen17()
    {
        String plainText = "12345678123456781";
        
        byte[] ciperText = AesUtil.encrypt(plainText.getBytes(), key);
        assertEquals(plainText.length(), ciperText.length);
        
        byte[] resultText = AesUtil.decrypt(ciperText, key);
        String resultString = new String(resultText, 0, plainText.length());
        assertEquals(plainText, resultString);     
    }

    @Test
    public void testLen20()
    {
        String plainText = "123456781234567812";
        
        byte[] ciperText = AesUtil.encrypt(plainText.getBytes(), key);
        assertEquals(plainText.length(), ciperText.length);
        
        byte[] resultText = AesUtil.decrypt(ciperText, key);
        String resultString = new String(resultText, 0, plainText.length());
        assertEquals(plainText, resultString);     
    }

    @Test
    public void testLen31()
    {
        String plainText = "1234567812345678123456781234567";
        
        byte[] ciperText = AesUtil.encrypt(plainText.getBytes(), key);
        assertEquals(plainText.length(), ciperText.length);
        
        byte[] resultText = AesUtil.decrypt(ciperText, key);
        String resultString = new String(resultText, 0, plainText.length());
        assertEquals(plainText, resultString);     
    }

}
