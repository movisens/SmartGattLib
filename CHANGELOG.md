<a name="3.2.0"></a>
# [3.2.0] (2019-09-03)

 - Added putMstime to GattByteBuffer

<a name="3.1.0"></a>
# [3.1.0] (2019-02-21)

 - Added getCharacteristics to obtain all Characteristics as a Collection

<a name="3.0.0"></a>
# [3.0.0](https://github.com/movisens/SmartGattLib/compare/v2.1...v3.0) (2017-11-07)

This release comes with a significant api change to simplify 

### Upgrade Instructions

* replace ```com.movisens.smartgattlib.Service``` with ```com.movisens.smartgattlib.Services```
* replace ```com.movisens.smartgattlib.Characteristic``` with ```com.movisens.smartgattlib.Characteristics```

It is now possible to parse Characteristics with:
``` java
AbstractAttribute a = Characteristics.lookup(uuid).createAttribute(data);
if (a instanceof HeartRateMeasurement) {
    HeartRateMeasurement heartRateMeasurement = ((HeartRateMeasurement) a);
    heartRateMeasurement.getHr();
    heartRateMeasurement.getEe();
} else if (a instanceof DefaultAttribute) {
    System.err.println("characteristic for " + uuid + " is unknown");
} else {
    System.out.println("unused characteristic " + a.getCharacteristic().getName());
}
```

It is also possible to write Characteristics and convert them to bytes:
``` java
AbstractAttribute aa = new Weight(12.3);
// TODO: Write aa.getBytes() to aa.getCharacteristic().getUuid();
```