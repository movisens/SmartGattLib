package com.movisens.smartgattlib;

import java.util.UUID;

import com.movisens.smartgattlib.helper.Service;
import com.movisens.smartgattlib.helper.UuidObjectMap;

public class Services
{

	public static final Service DEFAULT = new Service("0000", "Default Service");				
	public static final Service ALERT_NOTIFICATION = new Service("1811", "Alert Notification Service");
	public static final Service AUTOMATION_IO = new Service("1815", "Automation IO");
	public static final Service BATTERY_SERVICE = new Service("180f", "Battery Service");
	public static final Service BLOOD_PRESSURE = new Service("1810", "Blood Pressure");
	public static final Service BODY_COMPOSITION = new Service("181b", "Body Composition");
	public static final Service BOND_MANAGEMENT = new Service("181e", "Bond Management Service");
	public static final Service CONTINUOUS_GLUCOSE_MONITORING = new Service("181f", "Continuous Glucose Monitoring");
	public static final Service CURRENT_TIME = new Service("1805", "Current Time Service");
	public static final Service CYCLING_POWER = new Service("1818", "Cycling Power");
	public static final Service CYCLING_SPEED_AND_CADENCE = new Service("1816", "Cycling Speed and Cadence");
	public static final Service DEVICE_INFORMATION = new Service("180a", "Device Information");
	public static final Service ENVIRONMENTAL_SENSING = new Service("181a", "Environmental Sensing");
	public static final Service FITNESS_MACHINE = new Service("1826", "Fitness Machine");
	public static final Service GENERIC_ACCESS = new Service("1800", " Generic Access");
	public static final Service GENERIC_ATTRIBUTE = new Service("1801", "Generic Attribute");
	public static final Service GLUCOSE = new Service("1808", "Glucose");
	public static final Service HEALTH_THERMOMETER = new Service("1809", "Health Thermometer");
	public static final Service HEART_RATE = new Service("180d", "Heart Rate");
	public static final Service HTTP_PROXY = new Service("1823", "HTTP Proxy");
	public static final Service HUMAN_INTERFACE_DEVICE = new Service("1812", "Human Interface Device");
	public static final Service IMMEDIATE_ALERT = new Service("1802", "Immediate Alert");
	public static final Service INDOOR_POSITIONING = new Service("1821", "Indoor Positioning");
	public static final Service INTERNET_PROTOCOL_SUPPORT = new Service("1820", "Internet Protocol Support Service");
	public static final Service LINK_LOSS = new Service("1803", "Link Loss");
	public static final Service LOCATION_AND_NAVIGATION = new Service("1819", "Location and Navigation");
	public static final Service MESH_PROVISIONING = new Service("1827", "Mesh Provisioning Service");
	public static final Service MESH_PROXY = new Service("1828", "Mesh Proxy Service");
	public static final Service NEXT_DST_CHANGE = new Service("1807", "Next DST Change Service");
	public static final Service OBJECT_TRANSFER = new Service("1825", "Object Transfer Service");
	public static final Service PHONE_ALERT_STATUS = new Service("180e", "Phone Alert Status Service");
	public static final Service PULSE_OXIMETER = new Service("1822", "Pulse Oximeter Service");
	public static final Service REFERENCE_TIME_UPDATE = new Service("1806", "Reference Time Update Service");
	public static final Service RUNNING_SPEED_AND_CADENCE = new Service("1814", "Running Speed and Cadence");
	public static final Service SCAN_PARAMETERS = new Service("1813", "Scan Parameters");
	public static final Service TRANSPORT_DISCOVERY = new Service("1824", "Transport Discovery");
	public static final Service TX_POWER = new Service("1804", "Tx Power");
	public static final Service USER_DATA = new Service("181c", "User Data");
	public static final Service WEIGHT_SCALE = new Service("181d", "Weight Scale");

	private static UuidObjectMap<Service> services = new UuidObjectMap<Service>();

	static
	{
		services.put(ALERT_NOTIFICATION);
		services.put(AUTOMATION_IO);
		services.put(BATTERY_SERVICE);
		services.put(BLOOD_PRESSURE);
		services.put(BODY_COMPOSITION);
		services.put(BOND_MANAGEMENT);
		services.put(CONTINUOUS_GLUCOSE_MONITORING);
		services.put(CURRENT_TIME);
		services.put(CYCLING_POWER);
		services.put(CYCLING_SPEED_AND_CADENCE);
		services.put(DEVICE_INFORMATION);
		services.put(ENVIRONMENTAL_SENSING);
		services.put(FITNESS_MACHINE);
		services.put(GENERIC_ACCESS);
		services.put(GENERIC_ATTRIBUTE);
		services.put(GLUCOSE);
		services.put(HEALTH_THERMOMETER);
		services.put(HEART_RATE);
		services.put(HTTP_PROXY);
		services.put(HUMAN_INTERFACE_DEVICE);
		services.put(IMMEDIATE_ALERT);
		services.put(INDOOR_POSITIONING);
		services.put(INTERNET_PROTOCOL_SUPPORT);
		services.put(LINK_LOSS);
		services.put(LOCATION_AND_NAVIGATION);
		services.put(MESH_PROVISIONING);
		services.put(MESH_PROXY);
		services.put(NEXT_DST_CHANGE);
		services.put(OBJECT_TRANSFER);
		services.put(PHONE_ALERT_STATUS);
		services.put(PULSE_OXIMETER);
		services.put(REFERENCE_TIME_UPDATE);
		services.put(RUNNING_SPEED_AND_CADENCE);
		services.put(SCAN_PARAMETERS);
		services.put(TRANSPORT_DISCOVERY);
		services.put(TX_POWER);
		services.put(USER_DATA);
		services.put(WEIGHT_SCALE);
	}

	/**
	 * Looks up the service for the given UUID. If the UUID is not found, a lookup in the smartgattlib is performed.
	 * 
	 * @param uuid the UUID to look for
	 * @return the corresponding service or the DEFAULT service of smartgattlib if UUID is not found
	 */
	public static Service lookup(UUID uuid)
	{
		Service result = services.get(uuid);
		return result == null ? DEFAULT : result;
	}
}
