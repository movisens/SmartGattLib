package com.movisens.smartgattlib.security;

import javax.crypto.SecretKey;

public class CryptoManager
{

    private SecretKey secretKey = null;

    public void setKey(byte[] secretKey)
    {
        this.secretKey = AesUtil.createAesKey(secretKey);
    }

    public void initialize()
    {
        disableEncryption();
    }

    public void disableEncryption()
    {
        secretKey = null;
    }

    public boolean encryptionEnabled()
    {
        return secretKey != null;
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
