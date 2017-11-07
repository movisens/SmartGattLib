package com.movisens.smartgattlib.helper;

import com.movisens.smartgattlib.attributes.DefaultAttribute;

import java.util.UUID;

public class Characteristic extends UuidObject
{

    private Class<? extends AbstractAttribute> attributeClass;

    public Characteristic(String uuid, String name, Class<? extends AbstractAttribute> attributeClass)
    {
        super(uuid, name);
         this.attributeClass = attributeClass;
    }

    public AbstractAttribute createAttribute(byte[] data)
    {
        try
        {
            return attributeClass.getConstructor(byte[].class).newInstance(data);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
            return new DefaultAttribute(data);
        }
    }
    
    public Class<? extends AbstractAttribute> getAttributeClass()
    {
        return attributeClass;
    }
}
