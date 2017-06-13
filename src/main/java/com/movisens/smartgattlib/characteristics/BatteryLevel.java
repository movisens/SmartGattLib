package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractReadOnlyCharacteristic;

public class BatteryLevel extends AbstractReadOnlyCharacteristic<Short> {

    public BatteryLevel(byte[] bytes) {
        super(bytes, Characteristic.BATTERY_LEVEL);
    }

    @Override
    protected Short getValueForBytes(byte[] bytes) {
        return GattByteBuffer.wrap(bytes).getUint8();
    }

}
