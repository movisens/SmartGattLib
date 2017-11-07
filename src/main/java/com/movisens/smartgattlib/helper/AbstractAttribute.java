package com.movisens.smartgattlib.helper;

public abstract class AbstractAttribute
{

    protected byte[] data;

    public byte[] getBytes()
    {
        return data;
    }

    public abstract Characteristic getCharacteristic();

    public abstract boolean isReadable();

    public abstract boolean isWritable();

}
