package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Height {
	private byte[] bytes;
	private int value;

	/**
	 * 
	 * @param height
	 *            in cm
	 */
	public Height(int height) {
		this.value = height;
		this.bytes = GattByteBuffer.allocate(4).putUint16(height).array();
	}

	public Height(byte[] bytes) {
		this.bytes = bytes;
		this.value = GattByteBuffer.wrap(bytes).getUint16();
	}

	public byte[] getBytes() {
		return bytes;
	}

	public int getValue() {
		return value;
	}
}
