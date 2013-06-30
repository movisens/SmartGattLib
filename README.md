SmartGattLib
============

SmartGattLib is a Java library that simplifies the work with Bluetooth SMART devices (a.k.a Bluetooth Low Energy in Bluetooth 4.0). It provides all UUIDs of the adopted [GATT specification](http://developer.bluetooth.org/gatt/Pages/default.aspx) and an convenient way to interpret the characteristics (e.g. Heart Rate, BatteryLevel).

### Implemented and tested characteristics ###

 * BatteryLevel
 * BodySensorLocation
 * HeartRateMeasurement
 * ManufacturerNameString
 * More to come. Please commit pull request to add more characteristics.

### Compatibility ###
The library has no dependencies and can be use with every Bluetooth SMART stack e.g.:

 * Android API Level 18 (available soon)
 * [Samsung BLE SDK](http://developer.samsung.com/ble)
 * [HTC OpenSense BLE API](http://www.htcdev.com/devcenter/opensense-sdk/partner-apis/bluetooth-low-energy/)
 * Motorola (seems obsolete)

### Integration ###
Working with Bluetooth SMART devices is usually done in the following way:

1. Scan for devices
2. Connect to a GATT device
3. Discover services
4. Get characteristics for the services of interest **(SmartGattLib helps identifying the services)**
5. Read characteristics or register for updates **(SmartGattLib helps identifying the characteristics)**
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
if (Service.HEART_RATE.equals(serviceUuid)) { // Identify Service
	//TODO: iterate over characteristics
	UUID characteristicUuid = characteristic.getUuid();
	if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) { // Identify Characteristic
		// TODO: Enable notification
	}
}

// onCharacteristicChanged
UUID characteristicUuid = characteristic.getUuid();
if (Characteristic.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) { // Identify Characteristic
	byte[] value = characteristic.getValue();
	HeartRateMeasurement hrm = new HeartRateMeasurement(value); // Interpret Characteristic
	System.out.println("HR: " + hrm.getHr() + "bpm");
	System.out.println("EE: " + hrm.getEe() + "kJ");
}
```
### License ###
Copyright 2013 movisens GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
