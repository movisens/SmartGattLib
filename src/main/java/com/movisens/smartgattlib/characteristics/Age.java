package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractCharacteristic;

public class Age extends AbstractCharacteristic<Short> {

    public Age(byte[] bytes) {
        super(bytes, Characteristic.AGE);
    }

    public Age(Short value) {
        super(value, Characteristic.AGE);
    }


    @Override
    protected Short getValueForBytes(byte[] bytes) {
        return GattByteBuffer.wrap(bytes).getUint8();
    }

    @Override
    protected byte[] getBytesForValue(Short value) {
        return GattByteBuffer.allocate(4).putUint8(value).array();
    }

}
