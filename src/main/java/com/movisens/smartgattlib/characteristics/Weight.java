package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractCharacteristic;

public class Weight extends AbstractCharacteristic<Float> {

    public Weight(byte[] bytes) {
        super(bytes);
    }

    public Weight(Float value) {
        super(value);
    }

    @Override
    protected Float getValueForBytes(byte[] bytes) {
        return GattByteBuffer.wrap(bytes).getUint16() / 200f;
    }

    @Override
    protected byte[] getBytesForValue(Float value) {
        float storeWeight = value * 200;
        return GattByteBuffer.allocate(4).putUint16(Math.round(storeWeight)).array();
    }

}
