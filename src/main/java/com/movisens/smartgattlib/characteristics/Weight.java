package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Weight {
	private byte[] value;

	/**
	 * Constructor for new WeightCharacteristic
	 * 
	 * @param weight
	 *            in kg
	 */
	public Weight(float weight) {
		// https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.weight.xml
		float storeWeight = weight * 200;
		this.value = GattByteBuffer.allocate(4).putUint16(Math.round(storeWeight)).array();
	}

	public byte[] getValue() {
		return value;
	}

}
