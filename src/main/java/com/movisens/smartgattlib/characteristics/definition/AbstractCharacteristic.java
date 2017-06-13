package com.movisens.smartgattlib.characteristics.definition;

/**
 * Created by Robert Zetzsche on 07.03.2017.
 */

public abstract class AbstractCharacteristic<T> extends AbstractReadOnlyCharacteristic<T> {
    protected byte[] bytes;

    public AbstractCharacteristic(byte[] bytes) {
        super(bytes);
        this.bytes = bytes;
    }

    public AbstractCharacteristic(T value) {
        this.value = value;
        this.bytes = getBytesForValue(value);
    }

    public byte[] getBytes() {
        return bytes;
    }

    protected abstract T getValueForBytes(byte[] bytes);

    protected abstract byte[] getBytesForValue(T value);
}
