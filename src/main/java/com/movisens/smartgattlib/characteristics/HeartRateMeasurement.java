package com.movisens.smartgattlib.characteristics;

import java.util.ArrayList;

import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.GattUtils;

public class HeartRateMeasurement {

	ArrayList<Float> rrIntervals = new ArrayList<Float>();
	int hrmval = 0;
	int eeval = -1;
	SensorWorn sensorWorn = SensorWorn.UNSUPPORTED;

	public enum SensorWorn {
		UNSUPPORTED, WORN, NOT_WORN
	}

	public HeartRateMeasurement(byte[] value) {
		GattByteBuffer bb = GattByteBuffer.wrap(value);
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
	}

	private boolean isHeartRateInUINT16(byte flags) {
		if ((flags & GattUtils.FIRST_BITMASK) != 0)
			return true;
		return false;
	}

	private boolean isWornStatusPresent(byte flags) {
		if ((flags & GattUtils.THIRD_BITMASK) != 0)
			return true;
		return false;
	}

	private boolean isSensorWorn(byte flags) {
		if ((flags & GattUtils.SECOND_BITMASK) != 0)
			return true;
		return false;
	}

	private boolean isEePresent(byte flags) {
		if ((flags & GattUtils.FOURTH_BITMASK) != 0)
			return true;
		return false;
	}

	private boolean isRrIntPresent(byte flags) {
		if ((flags & GattUtils.FIFTH_BITMASK) != 0)
			return true;
		return false;
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
