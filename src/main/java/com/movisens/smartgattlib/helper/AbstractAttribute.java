package com.movisens.smartgattlib.helper;

import com.movisens.smartgattlib.security.CryptoManagerProvider;

public abstract class AbstractAttribute
{

    protected byte[] data;

    /**
     * Get data to be sent via BLE. This data may be encrypted.
     * 
     * @return data to send via BLE
     */
    public byte[] getOutgoingData()
    {
        if (getCharacteristic().isEncryptionAllowed())
        {
            return CryptoManagerProvider.get().processBeforeSend(data);
        }
        else
        {
            return data;
        }
    }

    /**
     * Gets the raw data representation of this attribute. This data is not encrypted.
     * 
     * @return raw adta representation
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
