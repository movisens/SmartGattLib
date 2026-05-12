# Changelog

## 4.1.0

- plain-text and encrypted attributes are handled consistently based on the attribute type
- attributes used for sealing and login now follow the encrypted BLE path

## 4.0.0

- breaking API change: `KeyGenerator.createKey(String)` now returns `long` instead of `long[]`
- `createKey(String)` now returns the scalar key used by the existing sealing and login APIs

## 3.6.1

- no fundamental API or functional changes since 3.6.0

## 3.6.0

- added application level encryption for over the air data
- added method getOutgoingData to AbstractAttribute that replaces the method getBytes and needs CryptoManager as argument
- added alternative signature for Characteristic.createAttribute: added new parameter for CryptoManager
- to get the raw data representation of an attribute the method getRawData was added to AbstractAttribute

## 3.2.0

 - Added putMstime to GattByteBuffer

## 3.1.0

 - Added getCharacteristics to obtain all Characteristics as a Collection

## 3.0.0

- started changelog
