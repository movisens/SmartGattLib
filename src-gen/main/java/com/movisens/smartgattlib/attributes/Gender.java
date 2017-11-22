package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Gender extends AbstractReadWriteAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.GENDER;
	
	private EnumGender gender;
	
	public EnumGender getGender()
	{
		return gender;
	}
	
	public String getGenderUnit()
	{
		return "";
	}
	
	public Gender(EnumGender gender)
	{
		this.gender = gender;
		GattByteBuffer bb = GattByteBuffer.allocate(1);
		bb.putUint8(gender.getValue());
		this.data = bb.array();
	}

	public Gender(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		gender = EnumGender.getByValue(bb.getUint8());
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getGender().toString();
	}
}
