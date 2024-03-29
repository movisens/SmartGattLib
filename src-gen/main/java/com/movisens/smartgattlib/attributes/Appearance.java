package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

public class Appearance extends AbstractReadAttribute implements PlainTextAttribute
{

	public static final Characteristic<Appearance> CHARACTERISTIC = Characteristics.APPEARANCE;
	
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
	public Characteristic<Appearance> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getCategory().toString();
	}
}
