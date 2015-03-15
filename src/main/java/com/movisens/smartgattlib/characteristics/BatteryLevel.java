package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class BatteryLevel {
	int level = -1;

	public BatteryLevel(byte[] value) {
		level = GattByteBuffer.wrap(value).getUint8();
	}

	/**
	 * @return The current charge level of a battery in %. 100% represents fully
	 *         charged while 0% represents fully discharged.
	 */
	public int getBatteryLevel() {
		return level;
	}
}
