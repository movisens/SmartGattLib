package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class ManufacturerNameString extends AbstractReadAttribute
{

	public static final Characteristic<ManufacturerNameString> CHARACTERISTIC = Characteristics.MANUFACTURER_NAME_STRING;
	
	private String manufacturer_Name;
	
	public String getManufacturer_Name()
	{
		return manufacturer_Name;
	}
	
	public String getManufacturer_NameUnit()
	{
		return "";
	}
	
	public ManufacturerNameString(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		manufacturer_Name = bb.getString();
	}

	@Override
	public Characteristic<ManufacturerNameString> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getManufacturer_Name().toString();
	}
}
