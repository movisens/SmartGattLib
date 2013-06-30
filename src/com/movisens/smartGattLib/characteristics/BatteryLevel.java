package com.movisens.smartGattLib.characteristics;

import com.movisens.smartGattLib.GattUtils;

public class BatteryLevel {
	int level = -1;

	public BatteryLevel(byte[] value) {
		level = GattUtils.getIntValue(value, GattUtils.FORMAT_UINT8, 0);
	}

	/**
	 * @return The current charge level of a battery in %. 100% represents fully
	 *         charged while 0% represents fully discharged.
	 */
	public int getBatteryLevel() {
		return level;
	}
}
