package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class BodySensorLocation {
	Location location = Location.Other;

	public enum Location {
		Other, Chest, Wrist, Finger, Hand, Ear_Lobe, Foot;
	}

	public BodySensorLocation(byte[] value) {
		int loc = GattByteBuffer.wrap(value).getUint8();

		switch (loc) {
		case 0:
			location = Location.Other;
			break;
		case 1:
			location = Location.Chest;
			break;
		case 2:
			location = Location.Wrist;
			break;
		case 3:
			location = Location.Finger;
			break;
		case 4:
			location = Location.Hand;
			break;
		case 5:
			location = Location.Ear_Lobe;
			break;
		case 6:
			location = Location.Foot;
			break;
		}
	}

	/**
	 * @return The current location of the sensor
	 */
	public Location getBodySensorLocation() {
		return location;
	}
}
