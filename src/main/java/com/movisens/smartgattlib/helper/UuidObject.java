package com.movisens.smartgattlib.helper;

import java.util.UUID;

public class UuidObject
{

    private static final long leastSigUuidBits = 0x800000805f9b34fbL;

    private UUID uuid;

    private String name;

    public UuidObject(String uuidString, String name)
    {
        this.uuid = stringToUuid(uuidString);
        this.name = name;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public String getName()
    {
        return name;
    }

    public static UUID stringToUuid(String uuidString)
    {
        UUID uuid;
        if (uuidString.length() == 4)
        {
            /* it is a short form uuid */
            uuid = new UUID((Long.parseLong(uuidString, 16) << 32) | 0x1000, leastSigUuidBits);
        }
        else
        {
            uuid = UUID.fromString(uuidString);
        }

        return uuid;
    }

    public boolean equals(UUID uuid) {
        return this.getUuid().equals(uuid);
    }
}
