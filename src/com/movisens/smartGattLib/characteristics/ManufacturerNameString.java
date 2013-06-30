package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattUtils;

public class ManufacturerNameString {
	String content = "";

	public ManufacturerNameString(byte[] value) {
		content = GattUtils.getStringValue(value, 0);
	}

	public String getManufacturerNameString() {
		return content;
	}
}
