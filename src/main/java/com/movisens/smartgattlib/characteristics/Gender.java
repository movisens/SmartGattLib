package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Gender {
	public static enum Sex {
		MALE((short) 0), FEMALE((short) 1);

		public final short value;

		private Sex(short value) {
			this.value = value;
		}
	}

	private byte[] value;

	public Gender(Sex sex) {
		this.value = GattByteBuffer.allocate(4).putUint8(sex.value).array();
	}

	public byte[] getValue() {
		return value;
	}

}
