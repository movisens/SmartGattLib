package com.movisens.smartgattlib.characteristics;

import java.util.ArrayList;

import com.movisens.smartgattlib.Characteristic;
import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.characteristics.definition.AbstractReadOnlyCharacteristic;

public class HeartRateMeasurement extends AbstractReadOnlyCharacteristic<Integer> {

    ArrayList<Float> rrIntervals = new ArrayList<Float>();
    int hrmval = 0;
    int eeval = -1;
    SensorWorn sensorWorn = SensorWorn.UNSUPPORTED;

    public HeartRateMeasurement(byte[] bytes) {
        super(bytes, Characteristic.HEART_RATE_MEASUREMENT);
    }

    public enum SensorWorn {
        UNSUPPORTED, WORN, NOT_WORN
    }

    @Override
    protected Integer getValueForBytes(byte[] bytes) {
        GattByteBuffer bb = GattByteBuffer.wrap(bytes);
        byte flags = bb.getInt8();
        if (isHeartRateInUINT16(flags)) {
            hrmval = bb.getUint16();
        } else {
            hrmval = bb.getUint8();
        }
        if (isWornStatusPresent(flags)) {
            if (isSensorWorn(flags)) {
                sensorWorn = SensorWorn.WORN;
            } else {
                sensorWorn = SensorWorn.NOT_WORN;
            }
        }
        if (isEePresent(flags)) {
            eeval = bb.getUint16();
        }
        if (isRrIntPresent(flags)) {
            while (bb.hasRemaining()) {
                rrIntervals.add(bb.getUint16() / 1024F);
            }
        }
        return hrmval;
    }

    private boolean isHeartRateInUINT16(byte flags) {
        return (flags & GattUtils.FIRST_BITMASK) != 0;
    }

    private boolean isWornStatusPresent(byte flags) {
        return (flags & GattUtils.THIRD_BITMASK) != 0;
    }

    private boolean isSensorWorn(byte flags) {
        return (flags & GattUtils.SECOND_BITMASK) != 0;
    }

    private boolean isEePresent(byte flags) {
        return (flags & GattUtils.FOURTH_BITMASK) != 0;
    }

    private boolean isRrIntPresent(byte flags) {
        return (flags & GattUtils.FIFTH_BITMASK) != 0;
    }

    /**
     * @return RR-Intervals. Units: seconds
     */
    public ArrayList<Float> getRrInterval() {
        return rrIntervals;
    }

    public int getHr() {
        return hrmval;
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
}
