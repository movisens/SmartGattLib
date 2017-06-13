package com.movisens.smartgattlib.characteristics.definition;

import java.util.UUID;

/**
 * Created by Robert Zetzsche on 07.03.2017.
 */

public abstract class AbstractReadOnlyCharacteristic<T> {
    protected T value;

    protected final UUID uuid;

    AbstractReadOnlyCharacteristic(UUID uuid) {
        this.uuid = uuid;
    }

    protected AbstractReadOnlyCharacteristic(byte[] bytes, UUID uuid) {
        this.value = getValueForBytes(bytes);
        this.uuid = uuid;
    }

    public T getValue() {
        return value;
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean isValid() {
        return true;
    }

    protected abstract T getValueForBytes(byte[] bytes);

    @Override
    public String toString() {
        return getClass().getSimpleName() + "=" + getValue();
    }
}
