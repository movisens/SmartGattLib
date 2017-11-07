package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class DateOfBirth extends AbstractReadWriteAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.DATE_OF_BIRTH;
	
	private Integer year;
	private Short month;
	private Short day;
	
	public Integer getYear()
	{
		return year;
	}
	
	public String getYearUnit()
	{
		return "";
	}
	
	public Short getMonth()
	{
		return month;
	}
	
	public String getMonthUnit()
	{
		return "";
	}
	
	public Short getDay()
	{
		return day;
	}
	
	public String getDayUnit()
	{
		return "";
	}
	
	public DateOfBirth(Integer year, Short month, Short day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
		GattByteBuffer bb = GattByteBuffer.allocate(4);
		bb.putUint16(year);
		bb.putUint8(month);
		bb.putUint8(day);
		this.data = bb.array();
	}

	public DateOfBirth(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		year = bb.getUint16();
		month = bb.getUint8();
		day = bb.getUint8();
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Date of Birth: " + "year = " + getYear() + " " + getYearUnit() + ", " + "month = " + getMonth() + " " + getMonthUnit() + ", " + "day = " + getDay() + " " + getDayUnit();
	}
}
