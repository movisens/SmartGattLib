package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Age {
	private byte[] bytes;
	private short value;

	/**
	 * 
	 * @param age
	 *            in years (for example 35,5)
	 */
	public Age(short age) {
		this.value = age;
		this.bytes = GattByteBuffer.allocate(4).putUint8(age).array();
	}

	public Age(byte[] bytes) {
		this.bytes = bytes;
		this.value = GattByteBuffer.wrap(bytes).getUint8();
	}

	public byte[] getBytes() {
		return bytes;
	}

	public short getValue() {
		return this.value;
	}

}
