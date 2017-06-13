package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.definition.AbstractReadOnlyCharacteristic;

public class BodySensorLocation extends AbstractReadOnlyCharacteristic<BodySensorLocation.Location> {

    public BodySensorLocation(byte[] bytes) {
        super(bytes, Characteristic.BODY_SENSOR_LOCATION);
    }

    public enum Location {
        Other, Chest, Wrist, Finger, Hand, Ear_Lobe, Foot;
    }

    @Override
    protected Location getValueForBytes(byte[] bytes) {
        Location location = Location.Other;
        int loc = GattByteBuffer.wrap(bytes).getUint8();

        switch (loc) {
            case 0:
                location = Location.Other;
                break;
            case 1:
                location = Location.Chest;
                break;
            case 2:
                location = Location.Wrist;
                break;
            case 3:
                location = Location.Finger;
                break;
            case 4:
                location = Location.Hand;
                break;
            case 5:
                location = Location.Ear_Lobe;
                break;
            case 6:
                location = Location.Foot;
                break;
        }
        return location;
    }

}
