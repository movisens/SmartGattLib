package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractCharacteristic;

public class Gender extends AbstractCharacteristic<Gender.Sex> {
    public Gender(byte[] bytes) {
        super(bytes, Characteristic.GENDER);
    }

    public Gender(Sex value) {
        super(value, Characteristic.GENDER);
    }

    public static enum Sex {
        MALE((short) 0), FEMALE((short) 1);

        public final short value;

        Sex(short value) {
            this.value = value;
        }
    }

    @Override
    protected Sex getValueForBytes(byte[] bytes) {
        if (GattByteBuffer.wrap(bytes).getUint8() == 0) {
            return Sex.MALE;
        } else {
            return Sex.FEMALE;
        }
    }

    @Override
    protected byte[] getBytesForValue(Sex value) {
        return GattByteBuffer.allocate(4).putUint8(value.value).array();
    }

}
