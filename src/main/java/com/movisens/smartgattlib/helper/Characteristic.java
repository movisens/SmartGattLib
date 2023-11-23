package com.movisens.smartgattlib.helper;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.function.Predicate;

import com.movisens.smartgattlib.attributes.DefaultAttribute;
import com.movisens.smartgattlib.security.CryptoManager;

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

    public AbstractAttribute createAttribute(CryptoManager cryptoManager, byte[] incommingData)
    {
        try
        {
            Constructor<T> constructor = attributeClass.getConstructor(byte[].class);

            if (isEncryptionAllowed())
            {
                return constructor.newInstance(cryptoManager.processAfterReceive(incommingData));
            }
            else
            {
                return constructor.newInstance(incommingData);
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
            return new DefaultAttribute(incommingData);
        }
    }

    public Class<T> getAttributeClass()
    {
        return attributeClass;
    }

    public boolean isEncryptionAllowed()
    {
        return Arrays.stream(attributeClass.getInterfaces()).filter(new Predicate<Class<?>>()
        {

            @Override
            public boolean test(Class<?> i)
            {
                return i.getName().equals(PlainTextAttribute.class.getName());
            }
        }).count() == 0;
    }

    @Override
    public String toString()
    {
        return getName();
    }

}
