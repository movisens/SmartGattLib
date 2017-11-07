package com.movisens.smartgattlib.descriptors;

import java.util.UUID;

import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.UuidObject;

public class ClientCharacteristicConfiguration
{

    public enum EnumProperties {

        Notifications(0), Indications(1);

        private final byte value;

        EnumProperties(int bitNumber)
        {
            this.value = (byte) (((byte) 1) << bitNumber);
        }
    }

    public static final UUID uuid = UuidObject.stringToUuid("2902");

    private byte[] data;

    private EnumProperties properties;

    public ClientCharacteristicConfiguration(EnumProperties properties)
    {
        this.properties = properties;
        GattByteBuffer bb = GattByteBuffer.allocate(2);
        bb.putUint16(this.properties.value);
        this.data = bb.array();
    }

    public byte[] getBytes()
    {
        return data;
    }

}
