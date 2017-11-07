package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractAttribute;
import com.movisens.smartgattlib.helper.Characteristic;

public class DefaultAttribute extends AbstractAttribute
{

    public DefaultAttribute(byte[] data)
    {
        this.data = data;
    }

    @Override
    public Characteristic getCharacteristic()
    {
        return Characteristics.DEFAULT;
    }

    @Override
    public String toString()
    {
        String result = this.getClass().getSimpleName() + " = ";
        for (byte d : data)
        {
            result += String.format("0x%02x ", d);
        }
        return result;
    }

    @Override
    public boolean isReadable()
    {
        return false;
    }

    @Override
    public boolean isWritable()
    {
        return false;
    }
}
