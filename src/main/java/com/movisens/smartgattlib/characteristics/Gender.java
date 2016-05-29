package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Gender {
	public static enum Sex {
		MALE((short) 0), FEMALE((short) 1);

		public final short value;

		Sex(short value) {
			this.value = value;
		}
	}

	private byte[] value;
	private Sex sex;

	public Gender(Sex sex) {
		this.sex = sex;
		this.value = GattByteBuffer.allocate(4).putUint8(sex.value).array();
	}

	public Gender(byte[] bytes) {
		this.value = bytes;
		if (GattByteBuffer.wrap(bytes).getUint8() == 0) {
			this.sex = Sex.MALE;
		} else {
			this.sex = Sex.FEMALE;
		}
	}

	public byte[] getBytes() {
		return value;
	}

	public Sex getValue() {
		return sex;
	}

}
