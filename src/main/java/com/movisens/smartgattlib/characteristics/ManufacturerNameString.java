package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractReadOnlyCharacteristic;

public class ManufacturerNameString extends AbstractReadOnlyCharacteristic<String> {

    public ManufacturerNameString(byte[] bytes) {
        super(bytes);
    }

    @Override
    protected String getValueForBytes(byte[] bytes) {
        return GattByteBuffer.wrap(bytes).getString();
    }
}
