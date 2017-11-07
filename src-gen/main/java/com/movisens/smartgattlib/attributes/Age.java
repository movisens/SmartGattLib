package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Age extends AbstractReadWriteAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.AGE;
	
	private Short age;
	
	public Short getAge()
	{
		return age;
	}
	
	public String getAgeUnit()
	{
		return "";
	}
	
	public Age(Short age)
	{
		this.age = age;
		GattByteBuffer bb = GattByteBuffer.allocate(1);
		bb.putUint8(age);
		this.data = bb.array();
	}

	public Age(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		age = bb.getUint8();
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Age: " + "age = " + getAge() + " " + getAgeUnit();
	}
}
