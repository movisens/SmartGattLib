package com.movisens.smartgattlib.helper;

public abstract class AbstractAttribute
{

    protected byte[] data;

    public byte[] getBytes()
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
        for(byte b : data)
        {
            result += String.format("0x%02x ", b);
        }

        return result;
    }

}
