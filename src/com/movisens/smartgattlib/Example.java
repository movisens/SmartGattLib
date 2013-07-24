package com.movisens.smartgattlib;

import java.util.UUID;

import com.movisens.smartgattlib.characteristics.HeartRateMeasurement;


public class Example {

	public static void main(String[] args) {
		// onConnected
		// TODO: iterate over available services
		UUID serviceUuid = null;// service.getUuid();
		if (Service.HEART_RATE.equals(serviceUuid)) {

			// TODO: iterate over characteristics
			UUID characteristicUuid = null;// characteristic.getUuid();
			if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) {
				// TODO: Enable notification
				//BluetoothGattDescriptor descriptor = characteristic.getDescriptor(Descriptor.CLIENT_CHARACTERISTIC_CONFIGURATION);
				//descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
				//mBluetoothGatt.writeDescriptor(descriptor);
			}
		}else{
			System.out.println("Found unused Service: " + Service.lookup(serviceUuid, "unknown"));
		}

		// onCharacteristicChanged
		UUID characteristicUuid = null;// characteristic.getUuid();
		if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) {
			byte[] value = null;// characteristic.getValue();
			HeartRateMeasurement hrm = new HeartRateMeasurement(value);
			hrm.getHr();
			hrm.getEe();
		}
	}
}
