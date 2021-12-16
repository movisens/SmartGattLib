package com.movisens.smartgattlib.security;

import javax.crypto.SecretKey;

import com.movisens.smartgattlib.helper.GattByteBuffer;

public class KeyGenerator
{
    public static long[] createKey(String password) {

        SecretKey key = AesUtil.createAesKey(password);
        GattByteBuffer bb = GattByteBuffer.wrap(key.getEncoded());

        long[] result = new long[2];
        result[0] = bb.getInt64();
        result[1] = bb.getInt64();

        return result;
    }
    
}
