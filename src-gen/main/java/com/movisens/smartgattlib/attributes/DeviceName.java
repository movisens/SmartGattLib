package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

public class DeviceName extends AbstractReadAttribute implements PlainTextAttribute
{

	public static final Characteristic<DeviceName> CHARACTERISTIC = Characteristics.DEVICE_NAME;
	
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
	public Characteristic<DeviceName> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getName().toString();
	}
}
