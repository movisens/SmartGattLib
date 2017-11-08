package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Appearance extends AbstractReadAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.APPEARANCE;
	
	private Short category;
	
	public Short getCategory()
	{
		return category;
	}
	
	public String getCategoryUnit()
	{
		return "";
	}
	
	public Appearance(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		category = bb.getInt16();
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Appearance: " + "category = " + getCategory();
	}
}
