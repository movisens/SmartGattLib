package com.movisens.smartgattlib;

import java.util.UUID;

import com.movisens.smartgattlib.attributes.DefaultAttribute;
import com.movisens.smartgattlib.attributes.BatteryLevel;
import com.movisens.smartgattlib.attributes.ModelNumberString;
import com.movisens.smartgattlib.attributes.FirmwareRevisionString;
import com.movisens.smartgattlib.attributes.Gender;
import com.movisens.smartgattlib.attributes.DateOfBirth;
import com.movisens.smartgattlib.attributes.HeartRateMeasurement;
import com.movisens.smartgattlib.attributes.Height;
import com.movisens.smartgattlib.attributes.Appearance;
import com.movisens.smartgattlib.attributes.ManufacturerNameString;
import com.movisens.smartgattlib.attributes.DeviceName;
import com.movisens.smartgattlib.attributes.Age;
import com.movisens.smartgattlib.attributes.Weight;
import com.movisens.smartgattlib.attributes.SerialNumberString;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.UuidObjectMap;

public class Characteristics
{

	public static final Characteristic DEFAULT = new Characteristic("0000", "Default Characteristic", DefaultAttribute.class);
	public static final Characteristic LONGITUDE = new Characteristic("2aaf", "Longitude", DefaultAttribute.class);
	public static final Characteristic MAGNETIC_FLUX_DENSITY_2D = new Characteristic("2aa0", "Magnetic Flux Density - 2D", DefaultAttribute.class);
	public static final Characteristic MAGNETIC_FLUX_DENSITY_3D = new Characteristic("2aa1", "Magnetic Flux Density - 3D", DefaultAttribute.class);
	public static final Characteristic AEROBIC_HEART_RATE_LOWER_LIMIT = new Characteristic("2a7e", "Aerobic Heart Rate Lower Limit", DefaultAttribute.class);
	public static final Characteristic AEROBIC_HEART_RATE_UPPER_LIMIT = new Characteristic("2a84", "Aerobic Heart Rate Upper Limit", DefaultAttribute.class);
	public static final Characteristic AEROBIC_THRESHOLD = new Characteristic("2a7f", "Aerobic Threshold", DefaultAttribute.class);
	public static final Characteristic AGE = new Characteristic("2a80", "Age", Age.class);
	public static final Characteristic AGGREGATE = new Characteristic("2a5a", "Aggregate", DefaultAttribute.class);
	public static final Characteristic ALERT_CATEGORY_ID = new Characteristic("2a43", "Alert Category ID", DefaultAttribute.class);
	public static final Characteristic ALERT_CATEGORY_ID_BIT_MASK = new Characteristic("2a42", "Alert Category ID Bit Mask", DefaultAttribute.class);
	public static final Characteristic ALERT_LEVEL = new Characteristic("2a06", "Alert Level", DefaultAttribute.class);
	public static final Characteristic ALERT_NOTIFICATION_CONTROL_POINT = new Characteristic("2a44", "Alert Notification Control Point", DefaultAttribute.class);
	public static final Characteristic ALERT_STATUS = new Characteristic("2a3f", "Alert Status", DefaultAttribute.class);
	public static final Characteristic ALTITUDE = new Characteristic("2ab3", "Altitude", DefaultAttribute.class);
	public static final Characteristic ANAEROBIC_HEART_RATE_LOWER_LIMIT = new Characteristic("2a81", "Anaerobic Heart Rate Lower Limit", DefaultAttribute.class);
	public static final Characteristic ANAEROBIC_HEART_RATE_UPPER_LIMIT = new Characteristic("2a82", "Anaerobic Heart Rate Upper Limit", DefaultAttribute.class);
	public static final Characteristic ANAEROBIC_THRESHOLD = new Characteristic("2a83", "Anaerobic Threshold", DefaultAttribute.class);
	public static final Characteristic ANALOG = new Characteristic("2a58", "Analog", DefaultAttribute.class);
	public static final Characteristic ANALOG_OUTPUT = new Characteristic("2a59", "Analog Output", DefaultAttribute.class);
	public static final Characteristic APPARENT_WIND_DIRECTION = new Characteristic("2a73", "Apparent Wind Direction", DefaultAttribute.class);
	public static final Characteristic APPARENT_WIND_SPEED = new Characteristic("2a72", "Apparent Wind Speed", DefaultAttribute.class);
	public static final Characteristic APPEARANCE = new Characteristic("2a01", "Appearance", Appearance.class);
	public static final Characteristic BAROMETRIC_PRESSURE_TREND = new Characteristic("2aa3", "Barometric Pressure Trend", DefaultAttribute.class);
	public static final Characteristic BATTERY_LEVEL = new Characteristic("2a19", "Battery Level", BatteryLevel.class);
	public static final Characteristic BATTERY_LEVEL_STATE = new Characteristic("2a1b", "Battery Level State", DefaultAttribute.class);
	public static final Characteristic BATTERY_POWER_STATE = new Characteristic("2a1a", "Battery Power State", DefaultAttribute.class);
	public static final Characteristic BLOOD_PRESSURE_FEATURE = new Characteristic("2a49", "Blood Pressure Feature", DefaultAttribute.class);
	public static final Characteristic BLOOD_PRESSURE_MEASUREMENT = new Characteristic("2a35", "Blood Pressure Measurement", DefaultAttribute.class);
	public static final Characteristic BODY_COMPOSITION_FEATURE = new Characteristic("2a9b", "Body Composition Feature", DefaultAttribute.class);
	public static final Characteristic BODY_COMPOSITION_MEASUREMENT = new Characteristic("2a9c", "Body Composition Measurement", DefaultAttribute.class);
	public static final Characteristic BODY_SENSOR_LOCATION = new Characteristic("2a38", "Body Sensor Location", BodySensorLocation.class);
	public static final Characteristic BOND_MANAGEMENT_CONTROL_POINT = new Characteristic("2aa4", "Bond Management Control Point", DefaultAttribute.class);
	public static final Characteristic BOND_MANAGEMENT_FEATURE = new Characteristic("2aa5", "Bond Management Features", DefaultAttribute.class);
	public static final Characteristic BOOT_KEYBOARD_INPUT_REPORT = new Characteristic("2a22", "Boot Keyboard Input Report", DefaultAttribute.class);
	public static final Characteristic BOOT_KEYBOARD_OUTPUT_REPORT = new Characteristic("2a32", "Boot Keyboard Output Report", DefaultAttribute.class);
	public static final Characteristic BOOT_MOUSE_INPUT_REPORT = new Characteristic("2a33", "Boot Mouse Input Report", DefaultAttribute.class);
	public static final Characteristic CGM_FEATURE = new Characteristic("2aa8", "CGM Feature", DefaultAttribute.class);
	public static final Characteristic CGM_MEASUREMENT = new Characteristic("2aa7", "CGM Measurement", DefaultAttribute.class);
	public static final Characteristic CGM_SESSION_RUN_TIME = new Characteristic("2aab", "CGM Session Run Time", DefaultAttribute.class);
	public static final Characteristic CGM_SESSION_START_TIME = new Characteristic("2aaa", "CGM Session Start Time", DefaultAttribute.class);
	public static final Characteristic CGM_SPECIFIC_OPS_CONTROL_POINT = new Characteristic("2aac", "CGM Specific Ops Control Point", DefaultAttribute.class);
	public static final Characteristic CGM_STATUS = new Characteristic("2aa9", "CGM Status", DefaultAttribute.class);
	public static final Characteristic CROSS_TRAINER_DATA = new Characteristic("2ace", "Cross Trainer Data", DefaultAttribute.class);
	public static final Characteristic CSC_FEATURE = new Characteristic("2a5c", "CSC Feature", DefaultAttribute.class);
	public static final Characteristic CSC_MEASUREMENT = new Characteristic("2a5b", "CSC Measurement", CyclingSpeedCadenceMeasurement.class);
	public static final Characteristic CURRENT_TIME = new Characteristic("2a2b", "Current Time", DefaultAttribute.class);
	public static final Characteristic CYCLING_POWER_CONTROL_POINT = new Characteristic("2a66", "Cycling Power Control Point", DefaultAttribute.class);
	public static final Characteristic CYCLING_POWER_FEATURE = new Characteristic("2a65", "Cycling Power Feature", DefaultAttribute.class);
	public static final Characteristic CYCLING_POWER_MEASUREMENT = new Characteristic("2a63", "Cycling Power Measurement", DefaultAttribute.class);
	public static final Characteristic CYCLING_POWER_VECTOR = new Characteristic("2a64", "Cycling Power Vector", DefaultAttribute.class);
	public static final Characteristic DATABASE_CHANGE_INCREMENT = new Characteristic("2a99", "Database Change Increment", DefaultAttribute.class);
	public static final Characteristic DATE_OF_BIRTH = new Characteristic("2a85", "Date of Birth", DateOfBirth.class);
	public static final Characteristic DATE_OF_THRESHOLD_ASSESSMENT = new Characteristic("2a86", "Date of Threshold Assessment", DefaultAttribute.class);
	public static final Characteristic DATE_TIME = new Characteristic("2a08", "Date Time", DefaultAttribute.class);
	public static final Characteristic DAY_DATE_TIME = new Characteristic("2a0a", "Day Date Time", DefaultAttribute.class);
	public static final Characteristic DAY_OF_WEEK = new Characteristic("2a09", "Day of Week", DefaultAttribute.class);
	public static final Characteristic DESCRIPTOR_VALUE_CHANGED = new Characteristic("2a7d", "Descriptor Value Changed", DefaultAttribute.class);
	public static final Characteristic DEVICE_NAME = new Characteristic("2a00", "Device Name", DeviceName.class);
	public static final Characteristic DEW_POINT = new Characteristic("2a7b", "Dew Point", DefaultAttribute.class);
	public static final Characteristic DIGITAL = new Characteristic("2a56", "Digital", DefaultAttribute.class);
	public static final Characteristic DIGITAL_OUTPUT = new Characteristic("2a57", "Digital Output", DefaultAttribute.class);
	public static final Characteristic DST_OFFSET = new Characteristic("2a0d", "DST Offset", DefaultAttribute.class);
	public static final Characteristic ELEVATION = new Characteristic("2a6c", "Elevation", DefaultAttribute.class);
	public static final Characteristic EMAIL_ADDRESS = new Characteristic("2a87", "Email Address", DefaultAttribute.class);
	public static final Characteristic EXACT_TIME_100 = new Characteristic("2a0b", "Exact Time 100", DefaultAttribute.class);
	public static final Characteristic EXACT_TIME_256 = new Characteristic("2a0c", "Exact Time 256", DefaultAttribute.class);
	public static final Characteristic FAT_BURN_HEART_RATE_LOWER_LIMIT = new Characteristic("2a88", "Fat Burn Heart Rate Lower Limit", DefaultAttribute.class);
	public static final Characteristic FAT_BURN_HEART_RATE_UPPER_LIMIT = new Characteristic("2a89", "Fat Burn Heart Rate Upper Limit", DefaultAttribute.class);
	public static final Characteristic FIRMWARE_REVISION_STRING = new Characteristic("2a26", "Firmware Revision String", FirmwareRevisionString.class);
	public static final Characteristic FIRST_NAME = new Characteristic("2a8a", "First Name", DefaultAttribute.class);
	public static final Characteristic FITNESS_MACHINE_CONTROL_POINT = new Characteristic("2ad9", "Fitness Machine Control Point", DefaultAttribute.class);
	public static final Characteristic FITNESS_MACHINE_FEATURE = new Characteristic("2acc", "Fitness Machine Feature", DefaultAttribute.class);
	public static final Characteristic FITNESS_MACHINE_STATUS = new Characteristic("2ada", "Fitness Machine Status", DefaultAttribute.class);
	public static final Characteristic FIVE_ZONE_HEART_RATE_LIMITS = new Characteristic("2a8b", "Five Zone Heart Rate Limits", DefaultAttribute.class);
	public static final Characteristic FLOOR_NUMBER = new Characteristic("2ab2", "Floor Number", DefaultAttribute.class);
	public static final Characteristic GENDER = new Characteristic("2a8c", "Gender", Gender.class);
	public static final Characteristic GLUCOSE_FEATURE = new Characteristic("2a51", "Glucose Feature", DefaultAttribute.class);
	public static final Characteristic GLUCOSE_MEASUREMENT = new Characteristic("2a18", "Glucose Measurement", DefaultAttribute.class);
	public static final Characteristic GLUCOSE_MEASUREMENT_CONTEXT = new Characteristic("2a34", "Glucose Measurement Context", DefaultAttribute.class);
	public static final Characteristic GUST_FACTOR = new Characteristic("2a74", "Gust Factor", DefaultAttribute.class);
	public static final Characteristic HARDWARE_REVISION_STRING = new Characteristic("2a27", "Hardware Revision String", DefaultAttribute.class);
	public static final Characteristic HEART_RATE_CONTROL_POINT = new Characteristic("2a39", "Heart Rate Control Point", DefaultAttribute.class);
	public static final Characteristic HEART_RATE_MAX = new Characteristic("2a8d", "Heart Rate Max", DefaultAttribute.class);
	public static final Characteristic HEART_RATE_MEASUREMENT = new Characteristic("2a37", "Heart Rate Measurement", HeartRateMeasurement.class);
	public static final Characteristic HEAT_INDEX = new Characteristic("2a7a", "Heat Index", DefaultAttribute.class);
	public static final Characteristic HEIGHT = new Characteristic("2a8e", "Height", Height.class);
	public static final Characteristic HID_CONTROL_POINT = new Characteristic("2a4c", "HID Control Point", DefaultAttribute.class);
	public static final Characteristic HID_INFORMATION = new Characteristic("2a4a", "HID Information", DefaultAttribute.class);
	public static final Characteristic HIP_CIRCUMFERENCE = new Characteristic("2a8f", "Hip Circumference", DefaultAttribute.class);
	public static final Characteristic HTTP_CONTROL_POINT = new Characteristic("2aba", "HTTP Control Point", DefaultAttribute.class);
	public static final Characteristic HTTP_ENTITY_BODY = new Characteristic("2ab9", "HTTP Entity Body", DefaultAttribute.class);
	public static final Characteristic HTTP_HEADERS = new Characteristic("2ab7", "HTTP Headers", DefaultAttribute.class);
	public static final Characteristic HTTP_STATUS_CODE = new Characteristic("2ab8", "HTTP Status Code", DefaultAttribute.class);
	public static final Characteristic HTTPS_SECURITY = new Characteristic("2abb", "HTTPS Security", DefaultAttribute.class);
	public static final Characteristic HUMIDITY = new Characteristic("2a6f", "Humidity", DefaultAttribute.class);
	public static final Characteristic IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST = new Characteristic("2a2a", "IEEE 11073-20601 Regulatory Certification Data List", DefaultAttribute.class);
	public static final Characteristic INDOOR_BIKE_DATA = new Characteristic("2ad2", "Indoor Bike Data", DefaultAttribute.class);
	public static final Characteristic INDOOR_POSITIONING_CONFIGURATION = new Characteristic("2aad", "Indoor Positioning Configuration", DefaultAttribute.class);
	public static final Characteristic INTERMEDIATE_CUFF_PRESSURE = new Characteristic("2a36", "Intermediate Cuff Pressure", DefaultAttribute.class);
	public static final Characteristic INTERMEDIATE_TEMPERATURE = new Characteristic("2a1e", "Intermediate Temperature", DefaultAttribute.class);
	public static final Characteristic IRRADIANCE = new Characteristic("2a77", "Irradiance", DefaultAttribute.class);
	public static final Characteristic LANGUAGE = new Characteristic("2aa2", "Language", DefaultAttribute.class);
	public static final Characteristic LAST_NAME = new Characteristic("2a90", "Last Name", DefaultAttribute.class);
	public static final Characteristic LATITUDE = new Characteristic("2aae", "Latitude", DefaultAttribute.class);
	public static final Characteristic LN_CONTROL_POINT = new Characteristic("2a6b", "LN Control Point", DefaultAttribute.class);
	public static final Characteristic LN_FEATURE = new Characteristic("2a6a", "LN Feature", DefaultAttribute.class);
	public static final Characteristic LOCAL_EAST_COORDINATE = new Characteristic("2ab1", "Local East Coordinate", DefaultAttribute.class);
	public static final Characteristic LOCAL_NORTH_COORDINATE = new Characteristic("2ab0", "Local North Coordinate", DefaultAttribute.class);
	public static final Characteristic LOCAL_TIME_INFORMATION = new Characteristic("2a0f", "Local Time Information", DefaultAttribute.class);
	public static final Characteristic LOCATION_AND_SPEED = new Characteristic("2a67", "Location and Speed Characteristic", DefaultAttribute.class);
	public static final Characteristic LOCATION_NAME = new Characteristic("2ab5", "Location Name", DefaultAttribute.class);
	public static final Characteristic MAGNETIC_DECLINATION = new Characteristic("2a2c", "Magnetic Declination", DefaultAttribute.class);
	public static final Characteristic MANUFACTURER_NAME_STRING = new Characteristic("2a29", "Manufacturer Name String", ManufacturerNameString.class);
	public static final Characteristic MAXIMUM_RECOMMENDED_HEART_RATE = new Characteristic("2a91", "Maximum Recommended Heart Rate", DefaultAttribute.class);
	public static final Characteristic MEASUREMENT_INTERVAL = new Characteristic("2a21", "Measurement Interval", DefaultAttribute.class);
	public static final Characteristic MODEL_NUMBER_STRING = new Characteristic("2a24", "Model Number String", ModelNumberString.class);
	public static final Characteristic NAVIGATION = new Characteristic("2a68", "Navigation", DefaultAttribute.class);
	public static final Characteristic NETWORK_AVAILABILITY = new Characteristic("2a3e", "Network Availability", DefaultAttribute.class);
	public static final Characteristic NEW_ALERT = new Characteristic("2a46", "New Alert", DefaultAttribute.class);
	public static final Characteristic OBJECT_ACTION_CONTROL_POINT = new Characteristic("2ac5", "Object Action Control Point", DefaultAttribute.class);
	public static final Characteristic OBJECT_CHANGED = new Characteristic("2ac8", "Object Changed", DefaultAttribute.class);
	public static final Characteristic OBJECT_FIRST_CREATED = new Characteristic("2ac1", "Object First-Created", DefaultAttribute.class);
	public static final Characteristic OBJECT_ID = new Characteristic("2ac3", "Object ID", DefaultAttribute.class);
	public static final Characteristic OBJECT_LAST_MODIFIED = new Characteristic("2ac2", "Object Last-Modified", DefaultAttribute.class);
	public static final Characteristic OBJECT_LIST_CONTROL_POINT = new Characteristic("2ac6", "Object List Control Point", DefaultAttribute.class);
	public static final Characteristic OBJECT_LIST_FILTER = new Characteristic("2ac7", "Object List Filter", DefaultAttribute.class);
	public static final Characteristic OBJECT_NAME = new Characteristic("2abe", "Object Name", DefaultAttribute.class);
	public static final Characteristic OBJECT_PROPERTIES = new Characteristic("2ac4", "Object Properties", DefaultAttribute.class);
	public static final Characteristic OBJECT_SIZE = new Characteristic("2ac0", "Object Size", DefaultAttribute.class);
	public static final Characteristic OBJECT_TYPE = new Characteristic("2abf", "Object Type", DefaultAttribute.class);
	public static final Characteristic OTS_FEATURE = new Characteristic("2abd", "OTS Feature", DefaultAttribute.class);
	public static final Characteristic PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS = new Characteristic("2a04", "Peripheral Preferred Connection Parameters", DefaultAttribute.class);
	public static final Characteristic PERIPHERAL_PRIVACY_FLAG = new Characteristic("2a02", "Peripheral Privacy Flag", DefaultAttribute.class);
	public static final Characteristic PLX_CONTINUOUS_MEASUREMENT = new Characteristic("2a5f", "PLX Continuous Measurement Characteristic", DefaultAttribute.class);
	public static final Characteristic PLX_FEATURES = new Characteristic("2a60", "PLX Features", DefaultAttribute.class);
	public static final Characteristic PLX_SPOT_CHECK_MEASUREMENT = new Characteristic("2a5e", "PLX Spot-Check Measurement", DefaultAttribute.class);
	public static final Characteristic PNP_ID = new Characteristic("2a50", "PnP ID", DefaultAttribute.class);
	public static final Characteristic POLLEN_CONCENTRATION = new Characteristic("2a75", "Pollen Concentration", DefaultAttribute.class);
	public static final Characteristic POSITION_2D = new Characteristic("2a2f", "Position 2D", DefaultAttribute.class);
	public static final Characteristic POSITION_3D = new Characteristic("2a30", "Position 3D", DefaultAttribute.class);
	public static final Characteristic POSITION_QUALITY = new Characteristic("2a69", "Position Quality", DefaultAttribute.class);
	public static final Characteristic PRESSURE = new Characteristic("2a6d", "Pressure", DefaultAttribute.class);
	public static final Characteristic PROTOCOL_MODE = new Characteristic("2a4e", "Protocol Mode", DefaultAttribute.class);
	public static final Characteristic PULSE_OXIMETRY_CONTROL_POINT = new Characteristic("2a62", "Pulse Oximetry Control Point", DefaultAttribute.class);
	public static final Characteristic RAINFALL = new Characteristic("2a78", "Rainfall", DefaultAttribute.class);
	public static final Characteristic RECONNECTION_ADDRESS = new Characteristic("2a03", "Reconnection Address", DefaultAttribute.class);
	public static final Characteristic RECORD_ACCESS_CONTROL_POINT = new Characteristic("2a52", "Record Access Control Point", DefaultAttribute.class);
	public static final Characteristic REFERENCE_TIME_INFORMATION = new Characteristic("2a14", "Reference Time Information", DefaultAttribute.class);
	public static final Characteristic REMOVABLE = new Characteristic("2a3a", "Removable", DefaultAttribute.class);
	public static final Characteristic REPORT = new Characteristic("2a4d", "Report", DefaultAttribute.class);
	public static final Characteristic REPORT_MAP = new Characteristic("2a4b", "Report Map", DefaultAttribute.class);
	public static final Characteristic RESOLVABLE_PRIVATE_ADDRESS_ONLY = new Characteristic("2ac9", "Resolvable Private Address Only", DefaultAttribute.class);
	public static final Characteristic RESTING_HEART_RATE = new Characteristic("2a92", "Resting Heart Rate", DefaultAttribute.class);
	public static final Characteristic RINGER_CONTROL_POINT = new Characteristic("2a40", "Ringer Control point", DefaultAttribute.class);
	public static final Characteristic RINGER_SETTING = new Characteristic("2a41", "Ringer Setting", DefaultAttribute.class);
	public static final Characteristic ROWER_DATA = new Characteristic("2ad1", "Rower Data", DefaultAttribute.class);
	public static final Characteristic RSC_FEATURE = new Characteristic("2a54", "RSC Feature", DefaultAttribute.class);
	public static final Characteristic RSC_MEASUREMENT = new Characteristic("2a53", "RSC Measurement", DefaultAttribute.class);
	public static final Characteristic SC_CONTROL_POINT = new Characteristic("2a55", "SC Control Point", DefaultAttribute.class);
	public static final Characteristic SCAN_INTERVAL_WINDOW = new Characteristic("2a4f", "Scan Interval Window", DefaultAttribute.class);
	public static final Characteristic SCAN_REFRESH = new Characteristic("2a31", "Scan Refresh", DefaultAttribute.class);
	public static final Characteristic SCIENTIFIC_TEMPERATURE_CELSIUS = new Characteristic("2a3c", "Scientific Temperature Celsius", DefaultAttribute.class);
	public static final Characteristic SECONDARY_TIME_ZONE = new Characteristic("2a10", "Secondary Time Zone", DefaultAttribute.class);
	public static final Characteristic SENSOR_LOCATION = new Characteristic("2a5d", "Sensor Location", DefaultAttribute.class);
	public static final Characteristic SERIAL_NUMBER_STRING = new Characteristic("2a25", "Serial Number String", SerialNumberString.class);
	public static final Characteristic SERVICE_CHANGED = new Characteristic("2a05", "Service Changed", DefaultAttribute.class);
	public static final Characteristic SERVICE_REQUIRED = new Characteristic("2a3b", "Service Required", DefaultAttribute.class);
	public static final Characteristic SOFTWARE_REVISION_STRING = new Characteristic("2a28", "Software Revision String", DefaultAttribute.class);
	public static final Characteristic SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS = new Characteristic("2a93", "Sport Type for Aerobic and Anaerobic Thresholds", DefaultAttribute.class);
	public static final Characteristic STAIR_CLIMBER_DATA = new Characteristic("2ad0", "Stair Climber Data", DefaultAttribute.class);
	public static final Characteristic STEP_CLIMBER_DATA = new Characteristic("2acf", "Step Climber Data", DefaultAttribute.class);
	public static final Characteristic STRING_ = new Characteristic("2a3d", "String", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_HEART_RATE_RANGE = new Characteristic("2ad7", "Supported Heart Rate Range", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_INCLINATION_RANGE = new Characteristic("2ad5", "Supported Inclination Range", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_NEW_ALERT_CATEGORY = new Characteristic("2a47", "Supported New Alert Category", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_POWER_RANGE = new Characteristic("2ad8", "Supported Power Range", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_RESISTANCE_LEVEL_RANGE = new Characteristic("2ad6", "Supported Resistance Level Range", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_SPEED_RANGE = new Characteristic("2ad4", "Supported Speed Range", DefaultAttribute.class);
	public static final Characteristic SUPPORTED_UNREAD_ALERT_CATEGORY = new Characteristic("2a48", "Supported Unread Alert Category", DefaultAttribute.class);
	public static final Characteristic SYSTEM_ID = new Characteristic("2a23", "System ID", DefaultAttribute.class);
	public static final Characteristic TDS_CONTROL_POINT = new Characteristic("2abc", "TDS Control Point", DefaultAttribute.class);
	public static final Characteristic TEMPERATURE = new Characteristic("2a6e", "Temperature", DefaultAttribute.class);
	public static final Characteristic TEMPERATURE_CELSIUS = new Characteristic("2a1f", "Temperature Celsius", DefaultAttribute.class);
	public static final Characteristic TEMPERATURE_FAHRENHEIT = new Characteristic("2a20", "Temperature Fahrenheit", DefaultAttribute.class);
	public static final Characteristic TEMPERATURE_MEASUREMENT = new Characteristic("2a1c", "Temperature Measurement", DefaultAttribute.class);
	public static final Characteristic TEMPERATURE_TYPE = new Characteristic("2a1d", "Temperature Type", DefaultAttribute.class);
	public static final Characteristic THREE_ZONE_HEART_RATE_LIMITS = new Characteristic("2a94", "Three Zone Heart Rate Limits", DefaultAttribute.class);
	public static final Characteristic TIME_ACCURACY = new Characteristic("2a12", "Time Accuracy", DefaultAttribute.class);
	public static final Characteristic TIME_BROADCAST = new Characteristic("2a15", "Time Broadcast", DefaultAttribute.class);
	public static final Characteristic TIME_SOURCE = new Characteristic("2a13", "Time Source", DefaultAttribute.class);
	public static final Characteristic TIME_UPDATE_CONTROL_POINT = new Characteristic("2a16", "Time Update Control Point", DefaultAttribute.class);
	public static final Characteristic TIME_UPDATE_STATE = new Characteristic("2a17", "Time Update State", DefaultAttribute.class);
	public static final Characteristic TIME_WITH_DST = new Characteristic("2a11", "Time with DST", DefaultAttribute.class);
	public static final Characteristic TIME_ZONE = new Characteristic("2a0e", "Time Zone", DefaultAttribute.class);
	public static final Characteristic TRAINING_STATUS = new Characteristic("2ad3", "Training Status", DefaultAttribute.class);
	public static final Characteristic TREADMILL_DATA = new Characteristic("2acd", "Treadmill Data", DefaultAttribute.class);
	public static final Characteristic TRUE_WIND_DIRECTION = new Characteristic("2a71", "True Wind Direction", DefaultAttribute.class);
	public static final Characteristic TRUE_WIND_SPEED = new Characteristic("2a70", "True Wind Speed", DefaultAttribute.class);
	public static final Characteristic TWO_ZONE_HEART_RATE_LIMIT = new Characteristic("2a95", "Two Zone Heart Rate Limit", DefaultAttribute.class);
	public static final Characteristic TX_POWER_LEVEL = new Characteristic("2a07", "Tx Power Level", DefaultAttribute.class);
	public static final Characteristic UNCERTAINTY = new Characteristic("2ab4", "Uncertainty", DefaultAttribute.class);
	public static final Characteristic UNREAD_ALERT_STATUS = new Characteristic("2a45", "Unread Alert Status", DefaultAttribute.class);
	public static final Characteristic URI = new Characteristic("2ab6", "URI", DefaultAttribute.class);
	public static final Characteristic USER_CONTROL_POINT = new Characteristic("2a9f", "User Control Point", DefaultAttribute.class);
	public static final Characteristic USER_INDEX = new Characteristic("2a9a", "User Index", DefaultAttribute.class);
	public static final Characteristic UV_INDEX = new Characteristic("2a76", "UV Index", DefaultAttribute.class);
	public static final Characteristic VO2_MAX = new Characteristic("2a96", "VO2 Max", DefaultAttribute.class);
	public static final Characteristic WAIST_CIRCUMFERENCE = new Characteristic("2a97", "Waist Circumference", DefaultAttribute.class);
	public static final Characteristic WEIGHT = new Characteristic("2a98", "Weight", Weight.class);
	public static final Characteristic WEIGHT_MEASUREMENT = new Characteristic("2a9d", "Weight Measurement", DefaultAttribute.class);
	public static final Characteristic WEIGHT_SCALE_FEATURE = new Characteristic("2a9e", "Weight Scale Feature", DefaultAttribute.class);
	public static final Characteristic WIND_CHILL = new Characteristic("2a79", "Wind Chill", DefaultAttribute.class);

	private static UuidObjectMap<Characteristic> characteristics = new UuidObjectMap<Characteristic>();

	static
	{
		characteristics.put(LONGITUDE);
		characteristics.put(MAGNETIC_FLUX_DENSITY_2D);
		characteristics.put(MAGNETIC_FLUX_DENSITY_3D);
		characteristics.put(AEROBIC_HEART_RATE_LOWER_LIMIT);
		characteristics.put(AEROBIC_HEART_RATE_UPPER_LIMIT);
		characteristics.put(AEROBIC_THRESHOLD);
		characteristics.put(AGE);
		characteristics.put(AGGREGATE);
		characteristics.put(ALERT_CATEGORY_ID);
		characteristics.put(ALERT_CATEGORY_ID_BIT_MASK);
		characteristics.put(ALERT_LEVEL);
		characteristics.put(ALERT_NOTIFICATION_CONTROL_POINT);
		characteristics.put(ALERT_STATUS);
		characteristics.put(ALTITUDE);
		characteristics.put(ANAEROBIC_HEART_RATE_LOWER_LIMIT);
		characteristics.put(ANAEROBIC_HEART_RATE_UPPER_LIMIT);
		characteristics.put(ANAEROBIC_THRESHOLD);
		characteristics.put(ANALOG);
		characteristics.put(ANALOG_OUTPUT);
		characteristics.put(APPARENT_WIND_DIRECTION);
		characteristics.put(APPARENT_WIND_SPEED);
		characteristics.put(APPEARANCE);
		characteristics.put(BAROMETRIC_PRESSURE_TREND);
		characteristics.put(BATTERY_LEVEL);
		characteristics.put(BATTERY_LEVEL_STATE);
		characteristics.put(BATTERY_POWER_STATE);
		characteristics.put(BLOOD_PRESSURE_FEATURE);
		characteristics.put(BLOOD_PRESSURE_MEASUREMENT);
		characteristics.put(BODY_COMPOSITION_FEATURE);
		characteristics.put(BODY_COMPOSITION_MEASUREMENT);
		characteristics.put(BODY_SENSOR_LOCATION);
		characteristics.put(BOND_MANAGEMENT_CONTROL_POINT);
		characteristics.put(BOND_MANAGEMENT_FEATURE);
		characteristics.put(BOOT_KEYBOARD_INPUT_REPORT);
		characteristics.put(BOOT_KEYBOARD_OUTPUT_REPORT);
		characteristics.put(BOOT_MOUSE_INPUT_REPORT);
		characteristics.put(CGM_FEATURE);
		characteristics.put(CGM_MEASUREMENT);
		characteristics.put(CGM_SESSION_RUN_TIME);
		characteristics.put(CGM_SESSION_START_TIME);
		characteristics.put(CGM_SPECIFIC_OPS_CONTROL_POINT);
		characteristics.put(CGM_STATUS);
		characteristics.put(CROSS_TRAINER_DATA);
		characteristics.put(CSC_FEATURE);
		characteristics.put(CSC_MEASUREMENT);
		characteristics.put(CURRENT_TIME);
		characteristics.put(CYCLING_POWER_CONTROL_POINT);
		characteristics.put(CYCLING_POWER_FEATURE);
		characteristics.put(CYCLING_POWER_MEASUREMENT);
		characteristics.put(CYCLING_POWER_VECTOR);
		characteristics.put(DATABASE_CHANGE_INCREMENT);
		characteristics.put(DATE_OF_BIRTH);
		characteristics.put(DATE_OF_THRESHOLD_ASSESSMENT);
		characteristics.put(DATE_TIME);
		characteristics.put(DAY_DATE_TIME);
		characteristics.put(DAY_OF_WEEK);
		characteristics.put(DESCRIPTOR_VALUE_CHANGED);
		characteristics.put(DEVICE_NAME);
		characteristics.put(DEW_POINT);
		characteristics.put(DIGITAL);
		characteristics.put(DIGITAL_OUTPUT);
		characteristics.put(DST_OFFSET);
		characteristics.put(ELEVATION);
		characteristics.put(EMAIL_ADDRESS);
		characteristics.put(EXACT_TIME_100);
		characteristics.put(EXACT_TIME_256);
		characteristics.put(FAT_BURN_HEART_RATE_LOWER_LIMIT);
		characteristics.put(FAT_BURN_HEART_RATE_UPPER_LIMIT);
		characteristics.put(FIRMWARE_REVISION_STRING);
		characteristics.put(FIRST_NAME);
		characteristics.put(FITNESS_MACHINE_CONTROL_POINT);
		characteristics.put(FITNESS_MACHINE_FEATURE);
		characteristics.put(FITNESS_MACHINE_STATUS);
		characteristics.put(FIVE_ZONE_HEART_RATE_LIMITS);
		characteristics.put(FLOOR_NUMBER);
		characteristics.put(GENDER);
		characteristics.put(GLUCOSE_FEATURE);
		characteristics.put(GLUCOSE_MEASUREMENT);
		characteristics.put(GLUCOSE_MEASUREMENT_CONTEXT);
		characteristics.put(GUST_FACTOR);
		characteristics.put(HARDWARE_REVISION_STRING);
		characteristics.put(HEART_RATE_CONTROL_POINT);
		characteristics.put(HEART_RATE_MAX);
		characteristics.put(HEART_RATE_MEASUREMENT);
		characteristics.put(HEAT_INDEX);
		characteristics.put(HEIGHT);
		characteristics.put(HID_CONTROL_POINT);
		characteristics.put(HID_INFORMATION);
		characteristics.put(HIP_CIRCUMFERENCE);
		characteristics.put(HTTP_CONTROL_POINT);
		characteristics.put(HTTP_ENTITY_BODY);
		characteristics.put(HTTP_HEADERS);
		characteristics.put(HTTP_STATUS_CODE);
		characteristics.put(HTTPS_SECURITY);
		characteristics.put(HUMIDITY);
		characteristics.put(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST);
		characteristics.put(INDOOR_BIKE_DATA);
		characteristics.put(INDOOR_POSITIONING_CONFIGURATION);
		characteristics.put(INTERMEDIATE_CUFF_PRESSURE);
		characteristics.put(INTERMEDIATE_TEMPERATURE);
		characteristics.put(IRRADIANCE);
		characteristics.put(LANGUAGE);
		characteristics.put(LAST_NAME);
		characteristics.put(LATITUDE);
		characteristics.put(LN_CONTROL_POINT);
		characteristics.put(LN_FEATURE);
		characteristics.put(LOCAL_EAST_COORDINATE);
		characteristics.put(LOCAL_NORTH_COORDINATE);
		characteristics.put(LOCAL_TIME_INFORMATION);
		characteristics.put(LOCATION_AND_SPEED);
		characteristics.put(LOCATION_NAME);
		characteristics.put(MAGNETIC_DECLINATION);
		characteristics.put(MANUFACTURER_NAME_STRING);
		characteristics.put(MAXIMUM_RECOMMENDED_HEART_RATE);
		characteristics.put(MEASUREMENT_INTERVAL);
		characteristics.put(MODEL_NUMBER_STRING);
		characteristics.put(NAVIGATION);
		characteristics.put(NETWORK_AVAILABILITY);
		characteristics.put(NEW_ALERT);
		characteristics.put(OBJECT_ACTION_CONTROL_POINT);
		characteristics.put(OBJECT_CHANGED);
		characteristics.put(OBJECT_FIRST_CREATED);
		characteristics.put(OBJECT_ID);
		characteristics.put(OBJECT_LAST_MODIFIED);
		characteristics.put(OBJECT_LIST_CONTROL_POINT);
		characteristics.put(OBJECT_LIST_FILTER);
		characteristics.put(OBJECT_NAME);
		characteristics.put(OBJECT_PROPERTIES);
		characteristics.put(OBJECT_SIZE);
		characteristics.put(OBJECT_TYPE);
		characteristics.put(OTS_FEATURE);
		characteristics.put(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS);
		characteristics.put(PERIPHERAL_PRIVACY_FLAG);
		characteristics.put(PLX_CONTINUOUS_MEASUREMENT);
		characteristics.put(PLX_FEATURES);
		characteristics.put(PLX_SPOT_CHECK_MEASUREMENT);
		characteristics.put(PNP_ID);
		characteristics.put(POLLEN_CONCENTRATION);
		characteristics.put(POSITION_2D);
		characteristics.put(POSITION_3D);
		characteristics.put(POSITION_QUALITY);
		characteristics.put(PRESSURE);
		characteristics.put(PROTOCOL_MODE);
		characteristics.put(PULSE_OXIMETRY_CONTROL_POINT);
		characteristics.put(RAINFALL);
		characteristics.put(RECONNECTION_ADDRESS);
		characteristics.put(RECORD_ACCESS_CONTROL_POINT);
		characteristics.put(REFERENCE_TIME_INFORMATION);
		characteristics.put(REMOVABLE);
		characteristics.put(REPORT);
		characteristics.put(REPORT_MAP);
		characteristics.put(RESOLVABLE_PRIVATE_ADDRESS_ONLY);
		characteristics.put(RESTING_HEART_RATE);
		characteristics.put(RINGER_CONTROL_POINT);
		characteristics.put(RINGER_SETTING);
		characteristics.put(ROWER_DATA);
		characteristics.put(RSC_FEATURE);
		characteristics.put(RSC_MEASUREMENT);
		characteristics.put(SC_CONTROL_POINT);
		characteristics.put(SCAN_INTERVAL_WINDOW);
		characteristics.put(SCAN_REFRESH);
		characteristics.put(SCIENTIFIC_TEMPERATURE_CELSIUS);
		characteristics.put(SECONDARY_TIME_ZONE);
		characteristics.put(SENSOR_LOCATION);
		characteristics.put(SERIAL_NUMBER_STRING);
		characteristics.put(SERVICE_CHANGED);
		characteristics.put(SERVICE_REQUIRED);
		characteristics.put(SOFTWARE_REVISION_STRING);
		characteristics.put(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS);
		characteristics.put(STAIR_CLIMBER_DATA);
		characteristics.put(STEP_CLIMBER_DATA);
		characteristics.put(STRING_);
		characteristics.put(SUPPORTED_HEART_RATE_RANGE);
		characteristics.put(SUPPORTED_INCLINATION_RANGE);
		characteristics.put(SUPPORTED_NEW_ALERT_CATEGORY);
		characteristics.put(SUPPORTED_POWER_RANGE);
		characteristics.put(SUPPORTED_RESISTANCE_LEVEL_RANGE);
		characteristics.put(SUPPORTED_SPEED_RANGE);
		characteristics.put(SUPPORTED_UNREAD_ALERT_CATEGORY);
		characteristics.put(SYSTEM_ID);
		characteristics.put(TDS_CONTROL_POINT);
		characteristics.put(TEMPERATURE);
		characteristics.put(TEMPERATURE_CELSIUS);
		characteristics.put(TEMPERATURE_FAHRENHEIT);
		characteristics.put(TEMPERATURE_MEASUREMENT);
		characteristics.put(TEMPERATURE_TYPE);
		characteristics.put(THREE_ZONE_HEART_RATE_LIMITS);
		characteristics.put(TIME_ACCURACY);
		characteristics.put(TIME_BROADCAST);
		characteristics.put(TIME_SOURCE);
		characteristics.put(TIME_UPDATE_CONTROL_POINT);
		characteristics.put(TIME_UPDATE_STATE);
		characteristics.put(TIME_WITH_DST);
		characteristics.put(TIME_ZONE);
		characteristics.put(TRAINING_STATUS);
		characteristics.put(TREADMILL_DATA);
		characteristics.put(TRUE_WIND_DIRECTION);
		characteristics.put(TRUE_WIND_SPEED);
		characteristics.put(TWO_ZONE_HEART_RATE_LIMIT);
		characteristics.put(TX_POWER_LEVEL);
		characteristics.put(UNCERTAINTY);
		characteristics.put(UNREAD_ALERT_STATUS);
		characteristics.put(URI);
		characteristics.put(USER_CONTROL_POINT);
		characteristics.put(USER_INDEX);
		characteristics.put(UV_INDEX);
		characteristics.put(VO2_MAX);
		characteristics.put(WAIST_CIRCUMFERENCE);
		characteristics.put(WEIGHT);
		characteristics.put(WEIGHT_MEASUREMENT);
		characteristics.put(WEIGHT_SCALE_FEATURE);
		characteristics.put(WIND_CHILL);
	}

	/**
	 * Looks up the characteristic for the given UUID. If the UUID is not found, a lookup in the smartgattlib is performed.
	 * 
	 * @param uuid the UUID to look for
	 * @return the corresponding characteristic or the DEFAULT characteristic of smartgattlib if UUID is not found
	 */
	public static Characteristic lookup(UUID uuid)
	{
		Characteristic result = characteristics.get(uuid);
		return result == null ? DEFAULT : result;
	}

}
