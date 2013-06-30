package com.movisens.smartgattlib;

import java.util.UUID;

public class GattUtils {
	public static final long leastSigBits = 0x800000805f9b34fbL;

	public static final int FIRST_BITMASK = 0x01;
	public static final int SECOND_BITMASK = FIRST_BITMASK << 1;
	public static final int THIRD_BITMASK = FIRST_BITMASK << 2;
	public static final int FOURTH_BITMASK = FIRST_BITMASK << 3;
	public static final int FIFTH_BITMASK = FIRST_BITMASK << 4;
	public static final int SIXTH_BITMASK = FIRST_BITMASK << 5;
	public static final int SEVENTH_BITMASK = FIRST_BITMASK << 6;
	public static final int EIGTH_BITMASK = FIRST_BITMASK << 7;

	public static final int FORMAT_UINT8 = 17;
	public static final int FORMAT_UINT16 = 18;
	public static final int FORMAT_UINT32 = 20;
	public static final int FORMAT_SINT8 = 33;
	public static final int FORMAT_SINT16 = 34;
	public static final int FORMAT_SINT32 = 36;
	public static final int FORMAT_SFLOAT = 50;
	public static final int FORMAT_FLOAT = 52;

	public static UUID toUuid(String uuidString) {
		return UUID.fromString(uuidString);
	}

	public static UUID toUuid(long assignedNumber) {
		return new UUID((assignedNumber << 32) | 0x1000, leastSigBits);
	}

	public static String toUuid128(long assignedNumber) {
		return toUuid(assignedNumber).toString();
	}

	public static String toUuid16(int assignedNumber) {
		return Integer.toHexString(assignedNumber);
	}

	public static Integer getIntValue(byte[] value, int format, int position) {
		if (value == null)
			return null;
		if (position + (format & 0xF) > value.length)
			return null;
		switch (format) {
		case FORMAT_UINT8:
			return Integer.valueOf(value[position] & 0xFF);
		case FORMAT_UINT16:
			return Integer.valueOf(add(value[position], value[(position + 1)]));
		case FORMAT_UINT32:
			return Integer.valueOf(add(value[position], value[(position + 1)],
					value[(position + 2)], value[(position + 3)]));
		case FORMAT_SINT8:
			return Integer.valueOf(signed(value[position] & 0xFF, 8));
		case FORMAT_SINT16:
			return Integer.valueOf(signed(
					add(value[position], value[(position + 1)]), 16));
		case FORMAT_SINT32:
			return Integer.valueOf(signed(
					add(value[position], value[(position + 1)],
							value[(position + 2)], value[(position + 3)]), 32));
		}
		return null;
	}

	public static Float getFloatValue(byte[] value, int format, int position) {
		if (value == null)
			return null;
		if (position + (format & 0xF) > value.length)
			return null;
		int i;
		int mantissa;
		int exponent;
		switch (format) {
		case FORMAT_SFLOAT:
			i = value[(position + 1)];
			position = value[position];
			mantissa = signed((position & 0xFF) + ((i & 0xFF & 0xF) << 8), 12);
			exponent = signed((i & 0xFF) >> 4, 4);
			return Float
					.valueOf((float) (mantissa * Math.pow(10.0D, exponent)));
		case FORMAT_FLOAT:
			exponent = value[(position + 3)];
			mantissa = value[(position + 2)];
			i = value[(position + 1)];
			position = value[position];
			return Float
					.valueOf((float) ((format = signed((position & 0xFF)
							+ ((i & 0xFF) << 8) + ((mantissa & 0xFF) << 16), 24)) * Math
							.pow(10.0D, exponent)));
		}
		return null;
	}

	public static String getStringValue(byte[] value, int position) {
		if (value == null)
			return null;
		if (position > value.length)
			return null;
		byte[] arrayOfByte = new byte[value.length - position];
		for (int i = 0; i != value.length - position; i++) {
			arrayOfByte[i] = value[(position + i)];
		}
		return new String(arrayOfByte);
	}

	private static int add(byte byte1, byte byte2) {
		return (byte1 & 0xFF) + ((byte2 & 0xFF) << 8);
	}

	private static int add(byte byte1, byte byte2, byte byte3, byte byte4) {
		return (byte1 & 0xFF) + ((byte2 & 0xFF) << 8) + ((byte3 & 0xFF) << 16)
				+ ((byte4 & 0xFF) << 24);
	}

	private static int signed(int value, int length) {
		if ((value & 1 << length - 1) != 0)
			value = -1 * ((1 << length - 1) - (value & (1 << length - 1) - 1));
		return value;
	}

	/**
	 * Convert hex byte array from motorola API to byte array.
	 * 
	 * @param hexByteArray
	 * @return
	 */
	public static byte[] hexByteArrayToByteArray(byte[] hexByteArray) {
		return hexStringToByteArray(new String(hexByteArray));
	}

	/**
	 * Convert string from motorola API to a byte array.
	 * 
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStringToByteArray(String hexString) {
		int len = hexString.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
					.digit(hexString.charAt(i + 1), 16));
		}
		return data;
	}
}
