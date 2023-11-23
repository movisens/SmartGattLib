package com.movisens.smartgattlib.helper;

import com.movisens.smartgattlib.security.CryptoManager;

public abstract class AbstractAttribute
{

    protected byte[] data;

    public byte[] getBytes()
    {
        return data;
    }

    /**
     * Get data to be sent via BLE. This data may be encrypted.
     * 
     * @return data to send via BLE
     */
    public byte[] getOutgoingData(CryptoManager cryptoManager)
    {
        if (getCharacteristic().isEncryptionAllowed())
        {
            return cryptoManager.processBeforeSend(data);
        }
        else
        {
            return data;
        }
    }

    /**
     * Gets the raw data representation of this attribute. This data is not encrypted.
     * 
     * @return raw data representation
     */
    public byte[] getRawData()
    {
        return data;
    }

    public abstract Characteristic<? extends AbstractAttribute> getCharacteristic();

    public boolean isReadable()
    {
        return false;
    }

    public boolean isWritable()
    {
        return false;
    }

    @Override
    public String toString()
    {
        String result = "";
        for (byte b : data)
        {
            result += String.format("0x%02x ", b);
        }

        return result;
    }
}
