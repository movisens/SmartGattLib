package com.movisens.smartgattlib.security;


public class CryptoManagerProvider
{
    private static CryptoManager cryptoManager = new CryptoManager();

    public static CryptoManager get()
    {
        return CryptoManagerProvider.cryptoManager;
    }

    public static void setSecurityManager(CryptoManager cryptoManager)
    {
        CryptoManagerProvider.cryptoManager = cryptoManager;
    }
    
}
