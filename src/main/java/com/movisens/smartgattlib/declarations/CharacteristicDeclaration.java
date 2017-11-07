package com.movisens.smartgattlib.declarations;

import java.util.UUID;

import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.UuidObject;

public class CharacteristicDeclaration
{

    enum EnumCharacteristicProperties {

        Broadcast(0), Read(1), WriteWithoutResponse(2), Write(3), Notify(4), Indicate(5), AuthenticatedSignedWrites(6), ExtendedProperties(7);

        private final byte value;

        EnumCharacteristicProperties(int bitNumber)
        {
            this.value = (byte) (((byte) 1) << bitNumber);
        }
    }

    public static final UUID uuid = UuidObject.stringToUuid("2803");

    private byte[] data;

    private short characteristicProperties;

    private int characteristicValueHandle;

    private UUID characteristicUuid;

    public CharacteristicDeclaration(byte[] data)
    {
        this.data = data;
        GattByteBuffer bb = GattByteBuffer.wrap(data);
        characteristicProperties = bb.getUint8();
        characteristicValueHandle = bb.getUint16();
        characteristicUuid = bb.getUuid();
    }

    public boolean supportsNotify()
    {
        return (characteristicProperties & EnumCharacteristicProperties.Notify.value) != 0;
    }

    public boolean supportsIndicate()
    {
        return (characteristicProperties & EnumCharacteristicProperties.Indicate.value) != 0;
    }

    public byte[] getData()
    {
        return data;
    }

    public short getCharacteristicProperties()
    {
        return characteristicProperties;
    }

    public int getCharacteristicValueHandle()
    {
        return characteristicValueHandle;
    }

    public UUID getCharacteristicUuid()
    {
        return characteristicUuid;
    }

    @Override
    public String toString()
    {
        String string = "CharacteristicDeclaration";
        string += " handle: " + characteristicValueHandle;
        string += " properties: ";
        for (EnumCharacteristicProperties cp : EnumCharacteristicProperties.values())
        {
            if ((characteristicProperties & cp.value) == cp.value)
            {
                string += cp.name().toUpperCase() + " ";
            }
        }
        string += " uuid: " + characteristicUuid.toString();
        return string;
    }

}
