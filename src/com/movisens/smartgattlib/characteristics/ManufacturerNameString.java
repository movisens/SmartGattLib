package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class ManufacturerNameString {
	String content = "";

	public ManufacturerNameString(byte[] value) {
		content = GattByteBuffer.wrap(value).getString();
	}

	public String getManufacturerNameString() {
		return content;
	}
}
