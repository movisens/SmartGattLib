package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

/**
 * The external appearance of this device. The values are composed of a category (10-bits) and sub-categories (6-bits).
 */
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
