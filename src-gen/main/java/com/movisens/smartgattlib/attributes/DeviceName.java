package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class DeviceName extends AbstractReadAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.DEVICE_NAME;
	
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public String getNameUnit()
	{
		return "";
	}
	
	public DeviceName(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		name = bb.getString();
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Device Name: " + "name = " + getName();
	}
}
