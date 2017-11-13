package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class BodySensorLocation extends AbstractReadAttribute {

    public enum Location {
        Other, Chest, Wrist, Finger, Hand, Ear_Lobe, Foot;
    }

    public static final Characteristic CHARACTERISTIC = Characteristics.BODY_SENSOR_LOCATION;

    private Location location;

    public Location getLocation()
    {
        return location;
    }

    public String getLocationUnit()
    {
        return "";
    }

    public BodySensorLocation(byte[] data)
    {
        this.data = data;
        location = Location.Other;
        int loc = GattByteBuffer.wrap(data).getUint8();

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
    }

    @Override
    public Characteristic getCharacteristic()
    {
        return CHARACTERISTIC;
    }

    @Override
    public String toString()
    {
        return "BodySensorLocation: " + "location = " + getLocation() + " " + getLocationUnit();
    }

}
