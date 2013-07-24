package com.movisens.smartgattlib;

import java.util.HashMap;
import java.util.UUID;

public class Descriptor {
	public static final UUID CHARACTERISTIC_EXTENDED_PROPERTIES = new UUID((0x2900L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID CHARACTERISTIC_USER_DESCRIPTION = new UUID((0x2901L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID CLIENT_CHARACTERISTIC_CONFIGURATION = new UUID((0x2902L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID SERVER_CHARACTERISTIC_CONFIGURATION = new UUID((0x2903L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID CHARACTERISTIC_PRESENTATION_FORMAT = new UUID((0x2904L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID CHARACTERISTIC_AGGREGATE_FORMAT = new UUID((0x2905L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID VALID_RANGE = new UUID((0x2906L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID EXTERNAL_REPORT_REFERENCE = new UUID((0x2907L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID REPORT_REFERENCE = new UUID((0x2908L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID NUMBER_OF_DIGITALS = new UUID((0x2909L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID TRIGGER_SETTING = new UUID((0x290AL << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID TEST_COMPLEX_BITFIELD = new UUID((0L << 32) | 0x1000, GattUtils.leastSigBits);
	
	private static HashMap<UUID, String> attributes = new HashMap<UUID, String>();
	static {
		attributes.put(CHARACTERISTIC_EXTENDED_PROPERTIES, "Characteristic Extended Properties");
		attributes.put(CHARACTERISTIC_USER_DESCRIPTION, "Characteristic User Description");
		attributes.put(CLIENT_CHARACTERISTIC_CONFIGURATION, "Client Characteristic Configuration");
		attributes.put(SERVER_CHARACTERISTIC_CONFIGURATION, "Server Characteristic Configuration");
		attributes.put(CHARACTERISTIC_PRESENTATION_FORMAT, "Characteristic Presentation Format");
		attributes.put(CHARACTERISTIC_AGGREGATE_FORMAT, "Characteristic Aggregate Format");
		attributes.put(VALID_RANGE, "Valid Range");
		attributes.put(EXTERNAL_REPORT_REFERENCE, "External Report Reference");
		attributes.put(REPORT_REFERENCE, "Report Reference");
		attributes.put(NUMBER_OF_DIGITALS, "Number of Digitals");
		attributes.put(TRIGGER_SETTING, "Trigger Setting");
		attributes.put(TEST_COMPLEX_BITFIELD, "Test Complex BitField");
    }

    public static String lookup(UUID uuid, String defaultName) {
        String name = attributes.get(uuid);
		return name == null ? defaultName : name;
	}
}