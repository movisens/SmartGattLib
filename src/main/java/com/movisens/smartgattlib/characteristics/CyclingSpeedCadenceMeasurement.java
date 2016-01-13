package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.GattUtils;

public class CyclingSpeedCadenceMeasurement {

    public static final int MAX_CUMULATIVE_CRANK_REVS = 65535;
    public static final long MAX_CUMULATIVE_WHEEL_REVS = 4294967295L;

    private boolean wheelRevPresent;
    private boolean crankRevPresent;

    private long cumulativeWheelRevolutions;
    private int lastWheelEventTime;
    private int cumulativeCrankRevolutions;
    private int lastCrankEventTime;

    public CyclingSpeedCadenceMeasurement(byte[] value) {
        super();

        GattByteBuffer bb = GattByteBuffer.wrap(value);

        byte flags = bb.getInt8();
        wheelRevPresent = wheelRevPresent(flags);
        crankRevPresent = crankRevPresent(flags);

        if (wheelRevPresent) {
            cumulativeWheelRevolutions = bb.getUint32();
            lastWheelEventTime = bb.getUint16();
        }

        if (crankRevPresent) {
            cumulativeCrankRevolutions = bb.getUint16();
            lastCrankEventTime = bb.getUint16();
        }
    }

    public boolean isWheelRevPresent() {
        return wheelRevPresent;
    }

    public boolean isCrankRevPresent() {
        return crankRevPresent;
    }

    public long getCumulativeWheelRevolutions() {
        return cumulativeWheelRevolutions;
    }

    //unit has resolution of 1/1024s
    public int getLastWheelEventTime() {
        return lastWheelEventTime;
    }

    public int getCumulativeCrankRevolutions() {
        return cumulativeCrankRevolutions;
    }

    //unit has resolution of 1/1024s
    public int getLastCrankEventTime() {
        return lastCrankEventTime;
    }

    private boolean wheelRevPresent(byte flags) {
        return (flags & GattUtils.FIRST_BITMASK) != 0;
    }

    private boolean crankRevPresent(byte flags) {
        return (flags & GattUtils.SECOND_BITMASK) != 0;
    }

    @Override
    public String toString() {
        return "SpeedCadenceMeasurement{" +
                "wheelRevPresent=" + wheelRevPresent +
                ", crankRevPresent=" + crankRevPresent +
                ", cumulativeWheelRevolutions=" + cumulativeWheelRevolutions +
                ", lastWheelEventTime=" + lastWheelEventTime +
                ", cumulativeCrankRevolutions=" + cumulativeCrankRevolutions +
                ", lastCrankEventTime=" + lastCrankEventTime +
                '}';
    }
}
