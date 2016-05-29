package com.movisens.smartgattlib.characteristics;

import com.movisens.smartgattlib.GattByteBuffer;

public class Weight {
	private byte[] bytes;
	private float value;

	/**
	 * Constructor for new WeightCharacteristic
	 * 
	 * @param weight
	 *            in kg
	 */
	public Weight(float weight) {
		// https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.weight.xml
		this.value = weight;
		float storeWeight = weight * 200;
		this.bytes = GattByteBuffer.allocate(4).putUint16(Math.round(storeWeight)).array();
	}

	public Weight(byte[] bytes) {
		// https://developer.bluetooth.org/gatt/characteristics/Pages/CharacteristicViewer.aspx?u=org.bluetooth.characteristic.weight.xml
		this.bytes = bytes;
		this.value = GattByteBuffer.wrap(bytes).getUint16() / 200;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public float getValue() {
		return value;
	}

}
