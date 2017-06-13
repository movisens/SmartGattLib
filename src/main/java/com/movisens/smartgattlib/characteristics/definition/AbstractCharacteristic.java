package com.movisens.smartgattlib.characteristics.definition;

import java.util.UUID;

/**
 * Created by Robert Zetzsche on 07.03.2017.
 */

public abstract class AbstractCharacteristic<T> extends AbstractReadOnlyCharacteristic<T> {
    protected byte[] bytes;

    protected AbstractCharacteristic(byte[] bytes, UUID uuid) {
        super(bytes, uuid);
        this.bytes = bytes;
    }

    protected AbstractCharacteristic(T value, UUID uuid) {
        super(uuid);
        this.value = value;
        this.bytes = getBytesForValue(value);
    }

    public byte[] getBytes() {
        return bytes;
    }

    protected abstract T getValueForBytes(byte[] bytes);

    protected abstract byte[] getBytesForValue(T value);
}
