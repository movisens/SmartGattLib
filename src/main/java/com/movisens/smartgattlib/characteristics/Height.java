package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractCharacteristic;

public class Height extends AbstractCharacteristic<Integer> {

    public Height(byte[] bytes) {
        super(bytes, Characteristic.HEIGHT);
    }

    public Height(Integer value) {
        super(value, Characteristic.HEIGHT);
    }

    @Override
    protected Integer getValueForBytes(byte[] bytes) {
        return GattByteBuffer.wrap(bytes).getUint16();
    }

    @Override
    protected byte[] getBytesForValue(Integer value) {
        return GattByteBuffer.allocate(4).putUint16(value).array();
    }

}
