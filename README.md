SmartGattLib
============

SmartGattLib is a Java library that simplifies the work with Bluetooth SMART devices. It provides all UUIDs of the adopted [GATT specification](http://developer.bluetooth.org/gatt/Pages/default.aspx) and an convenient way to interpret the characteristics (e.g. Heart Rate, BatteryLevel).

Currently implemented and tested characteristics:

 * BatteryLevel
 * BodySensorLocation
 * HeartRateMeasurement
 * ManufacturerNameString
 * More to come. Please commit pull request to add more characteristics.

The library has no dependencies and can be use with every Bluetooth SMART stack e.g.:

 * Android API Level 18 (available soon)
 * [Samsung BLE SDK](http://developer.samsung.com/ble)
 * [HTC OpenSense BLE API](http://www.htcdev.com/devcenter/opensense-sdk/partner-apis/bluetooth-low-energy/)
 * Motorola (seems obsolete)

Working with Bluetooth SMART devices is usually done in the following way:

1. Scan for devices
2. Connect to a GATT device
3. Discover services
4. Get characteristics for the services of interest **(SmartGattLib helps identifying the services)**
5. Read characteristics or register for updates of the characteristics **(SmartGattLib helps identifying the characteristics)**
6. Interpret the updates from the characteristics **(SmartGattLib helps interpreting the data)**

### Set up ###

1. Download the latest .jar file from the releases folder and place it in your Android app’s libs/ folder.
2. Use the example below to identifiy services and characteristics and interpret their data

### Example Usage ###
```java
import com.movisens.smartgattlib.*;

// onConnected
//TODO: iterate over available services
UUID serviceUuid = service.getUuid();
if (Service.HEART_RATE.equals(serviceUuid)) {
	
	//TODO: iterate over characteristics
	UUID characteristicUuid = characteristic.getUuid();
	if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) {
		// TODO: Enable notification
	}
}

// onCharacteristicChanged
UUID characteristicUuid = characteristic.getUuid();
if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) {
	byte[] value = characteristic.getValue();
	HeartRateMeasurement hrm = new HeartRateMeasurement(value);
	hrm.getHr();
	hrm.getEe();
}
```
