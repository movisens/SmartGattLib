package com.movisens.smartgattlib.helper;

import java.util.HashMap;
import java.util.UUID;

public class UuidObjectMap<T extends UuidObject>
{

    private HashMap<UUID, T> map = new HashMap<UUID, T>();

    public void put(T uuidObject)
    {
        map.put(uuidObject.getUuid(), uuidObject);
    }

    public T get(UUID uuid)
    {
        return map.get(uuid);
    }
}
