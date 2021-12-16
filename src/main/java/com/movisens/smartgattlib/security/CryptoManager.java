package com.movisens.smartgattlib.security;

import javax.crypto.SecretKey;

public class CryptoManager
{
    private SecretKey secretKey = null;

    public void setPassword(String password)
    {
        secretKey = AesUtil.createAesKey(password);
    }

    public void removePassword()
    {
        secretKey = null;
    }

    public byte[] processBeforeSend(byte[] data)
    {
        if (secretKey != null)
        {
            return AesUtil.encrypt(data, secretKey);
        }
        else
        {
            return data;
        }
    }

    public byte[] processAfterReceive(byte[] data)
    {
        if (secretKey != null)
        {
            return AesUtil.decrypt(data, secretKey);
        }
        else
        {
            return data;
        }
    }
}
