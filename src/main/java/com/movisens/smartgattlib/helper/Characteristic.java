package com.movisens.smartgattlib.helper;

import com.movisens.smartgattlib.attributes.DefaultAttribute;

public class Characteristic<T extends AbstractAttribute> extends UuidObject
{
    private Class<T> attributeClass;
    
    Characteristic<?> requiredCharacteristics[];

    public Characteristic<?>[] getRequiredCharacteristics()
    {
        return requiredCharacteristics;
    }

    public Characteristic(String uuid, String name, Class<T> attributeClass, Characteristic<?>... requiredCharacteristics)
    {
        super(uuid, name);
        this.attributeClass = attributeClass;
        this.requiredCharacteristics = requiredCharacteristics;
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
    
    public Class<T> getAttributeClass()
    {
        return attributeClass;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
