package com.movisens.smartGattLib;

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
}