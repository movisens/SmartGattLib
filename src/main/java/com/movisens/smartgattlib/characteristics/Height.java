package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Height {
	private byte[] value;

	/**
	 * 
	 * @param height
	 *            in cm
	 */
	public Height(int height) {
		this.value = GattByteBuffer.allocate(4).putUint16(height).array();
	}

	public byte[] getValue() {
		return value;
	}
}
