package com.movisens.smartgattlib.attributes;

import java.util.ArrayList;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class HeartRateMeasurement extends AbstractReadAttribute
{

    public static final Characteristic<HeartRateMeasurement> CHARACTERISTIC = Characteristics.HEART_RATE_MEASUREMENT;

    ArrayList<Float> rrIntervals = new ArrayList<Float>();
    int hrmval = 0;
    int eeval = -1;
    byte flags;
    HeartRateMeasurement.SensorWorn sensorWorn = HeartRateMeasurement.SensorWorn.UNSUPPORTED;

    public enum SensorWorn {
        UNSUPPORTED, WORN, NOT_WORN
    }

    public HeartRateMeasurement(byte[] data)
    {
        this.data = data;
        GattByteBuffer bb = GattByteBuffer.wrap(data);
        flags = bb.getInt8();
        if (isHeartRateInUINT16()) {
            hrmval = bb.getUint16();
        } else {
            hrmval = bb.getUint8();
        }
        if (isWornStatusPresent()) {
            if (isSensorWorn()) {
                sensorWorn = HeartRateMeasurement.SensorWorn.WORN;
            } else {
                sensorWorn = HeartRateMeasurement.SensorWorn.NOT_WORN;
            }
        }
        if (isEePresent()) {
            eeval = bb.getUint16();
        }
        if (isRrIntPresent()) {
            while (bb.hasRemaining()) {
                rrIntervals.add(bb.getUint16() / 1024F);
            }
        }
    }

    public boolean isHeartRateInUINT16() {
        return (flags & GattUtils.FIRST_BITMASK) != 0;
    }

    public boolean isWornStatusPresent() {
        return (flags & GattUtils.THIRD_BITMASK) != 0;
    }

    public boolean isSensorWorn() {
        return (flags & GattUtils.SECOND_BITMASK) != 0;
    }

    public boolean isEePresent() {
        return (flags & GattUtils.FOURTH_BITMASK) != 0;
    }

    public boolean isRrIntPresent() {
        return (flags & GattUtils.FIFTH_BITMASK) != 0;
    }

    /**
     * @return RR-Intervals. Units: seconds
     */
    public ArrayList<Float> getRrIntervals() {
        return rrIntervals;
    }

    public int getHr() {
        return hrmval;
    }

    public String getHrUnit() {
        return "bpm";
    }

    /**
     * @return Energy Expended, Units: kilo Joules
     */
    public int getEe() {
        return eeval;
    }

    public SensorWorn getSensorWorn() {
        return sensorWorn;
    }

    @Override
    public Characteristic<HeartRateMeasurement> getCharacteristic()
    {
        return CHARACTERISTIC;
    }

    @Override
    public String toString()
    {
        return "Heart Rate Measurement: " + "hr = " + getHr() + " " + getHrUnit() + ", " + "ee = " + getEe() + ", " + "sensorworn = " + getSensorWorn();
    }
}
