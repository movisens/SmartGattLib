package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Age {
	private byte[] value;

	/**
	 * 
	 * @param age
	 *            in years (for example 35,5)
	 */
	public Age(short age) {
		this.value = GattByteBuffer.allocate(4).putUint8(age).array();
	}

	public byte[] getValue() {
		return value;
	}

}
