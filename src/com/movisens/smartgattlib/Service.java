package com.movisens.smartgattlib;

import java.util.HashMap;
import java.util.UUID;

public class Service {
	public static final UUID ALERT_NOTIFICATION_SERVICE = new UUID((0x1811L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID BATTERY_SERVICE = new UUID((0x180FL << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID BLOOD_PRESSURE = new UUID((0x1810L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID CURRENT_TIME_SERVICE = new UUID((0x1805L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID CYCLING_POWER = new UUID((0x1818L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID CYCLING_SPEED_AND_CADENCE = new UUID((0x1816L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID DEVICE_INFORMATION = new UUID((0x180AL << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID GENERIC_ACCESS = new UUID((0x1800L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID GENERIC_ATTRIBUTE = new UUID((0x1801L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID GLUCOSE = new UUID((0x1808L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID HEALTH_THERMOMETER = new UUID((0x1809L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID HEART_RATE = new UUID((0x180DL << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID HUMAN_INTERFACE_DEVICE = new UUID((0x1812L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID IMMEDIATE_ALERT = new UUID((0x1802L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID LINK_LOSS = new UUID((0x1803L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID LOCATION_AND_NAVIGATION = new UUID((0x1819L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID NEXT_DST_CHANGE_SERVICE = new UUID((0x1807L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID PHONE_ALERT_STATUS_SERVICE = new UUID((0x180EL << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID REFERENCE_TIME_UPDATE_SERVICE = new UUID((0x1806L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID RUNNING_SPEED_AND_CADENCE = new UUID((0x1814L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID SCAN_PARAMETERS = new UUID((0x1813L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID TX_POWER = new UUID((0x1804L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID AUTOMATION_IO = new UUID((0x1815L << 32) | 0x1000,GattUtils.leastSigBits);
	public static final UUID BATTERY_SERVICE_1_1 = new UUID((0x180FL << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID IMMEDIATE_ALERT_SERVICE_1_1 = new UUID((0x1802L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID LINK_LOSS_SERVICE_1_1 = new UUID((0x1803L << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID NETWORK_AVAILABILITY_SERVICE = new UUID((0x180BL << 32) | 0x1000, GattUtils.leastSigBits);
	public static final UUID TX_POWER_SERVICE_1_1 = new UUID((0x1804L << 32) | 0x1000, GattUtils.leastSigBits);
	
	private static HashMap<UUID, String> attributes = new HashMap<UUID, String>();
	static {
		attributes.put(ALERT_NOTIFICATION_SERVICE, "Alert Notification Service");
		attributes.put(BATTERY_SERVICE, "Battery Service");
		attributes.put(BLOOD_PRESSURE, "Blood Pressure");
		attributes.put(CURRENT_TIME_SERVICE, "Current Time Service");
		attributes.put(CYCLING_POWER, "Cycling Power");
		attributes.put(CYCLING_SPEED_AND_CADENCE, "Cycling Speed and Cadence");
		attributes.put(DEVICE_INFORMATION, "Device Information");
		attributes.put(GENERIC_ACCESS, "Generic Access");
		attributes.put(GENERIC_ATTRIBUTE, "Generic Attribute");
		attributes.put(GLUCOSE, "Glucose");
		attributes.put(HEALTH_THERMOMETER, "Health Thermometer");
		attributes.put(HEART_RATE, "Heart Rate");
		attributes.put(HUMAN_INTERFACE_DEVICE, "Human Interface Device");
		attributes.put(IMMEDIATE_ALERT, "Immediate Alert");
		attributes.put(LINK_LOSS, "Link Loss");
		attributes.put(LOCATION_AND_NAVIGATION, "Location and Navigation");
		attributes.put(NEXT_DST_CHANGE_SERVICE, "Next DST Change Service");
		attributes.put(PHONE_ALERT_STATUS_SERVICE, "Phone Alert Status Service");
		attributes.put(REFERENCE_TIME_UPDATE_SERVICE, "Reference Time Update Service");
		attributes.put(RUNNING_SPEED_AND_CADENCE, "Running Speed and Cadence");
		attributes.put(SCAN_PARAMETERS, "Scan Parameters");
		attributes.put(TX_POWER, "Tx Power");
		attributes.put(AUTOMATION_IO, "Automation IO");
		attributes.put(BATTERY_SERVICE_1_1, "Battery Service v1.1");
		attributes.put(IMMEDIATE_ALERT_SERVICE_1_1, "Immediate Alert Service 1.1");
		attributes.put(LINK_LOSS_SERVICE_1_1, "Link Loss Service 1.1");
		attributes.put(NETWORK_AVAILABILITY_SERVICE, "Network Availability Service");
		attributes.put(TX_POWER_SERVICE_1_1, "Tx Power Service 1.1");
    }

    public static String lookup(UUID uuid, String defaultName) {
        String name = attributes.get(uuid);
		return name == null ? defaultName : name;
	}
}