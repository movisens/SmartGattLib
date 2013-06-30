package com.movisens.smartGattLib.characteristics;

import com.movisens.smartGattLib.GattUtils;

public class ManufacturerNameString {
	String content = "";

	public ManufacturerNameString(byte[] value) {
		content = GattUtils.getStringValue(value, 0);
	}

	public String getManufacturerNameString() {
		return content;
	}
}
