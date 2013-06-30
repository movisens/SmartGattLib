package com.movisens.smartGattLib.characteristics;

import java.util.ArrayList;

import com.movisens.smartGattLib.GattUtils;



public class HeartRateMeasurement {

	ArrayList<Float> rrIntervals = new ArrayList<Float>();
	int hrmval = 0;
	int eeval = -1;
	SensorWorn sensorWorn = SensorWorn.UNSUPPORTED;

	public enum SensorWorn {
		UNSUPPORTED, WORN, NOT_WORN
	}

	public HeartRateMeasurement(byte[] value) {
		int length = value.length;
		int offset = 1;
		byte flags = value[0];
		if (isHeartRateInUINT16(flags)) {
			hrmval = GattUtils.getIntValue(value, GattUtils.FORMAT_UINT16,
					offset);
			offset += 2;
		} else {
			hrmval = GattUtils.getIntValue(value, GattUtils.FORMAT_UINT8,
					offset);
			offset += 1;
		}
		if (isWornStatusPresent(flags)) {
			if (isSensorWorn(flags)) {
				sensorWorn = SensorWorn.WORN;
			} else {
				sensorWorn = SensorWorn.NOT_WORN;
			}
		}
		if (isEePresent(flags)) {
			eeval = GattUtils.getIntValue(value, GattUtils.FORMAT_UINT16,
					offset);
			offset += 2;
		}
		if (isRrIntPresent(flags)) {
			for (int i = offset; i < length; i += 2) {
				rrIntervals.add(GattUtils.getIntValue(value,
						GattUtils.FORMAT_UINT16, i) / 1024F);
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
