package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class BatteryLevel extends AbstractReadAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.BATTERY_LEVEL;
	
	private Double level;
	
	public Double getLevel()
	{
		return level;
	}
	
	public String getLevelUnit()
	{
		return "%";
	}
	
	public BatteryLevel(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		level = new Double(bb.getUint8());
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Battery Level: " + "level = " + getLevel() + " " + getLevelUnit();
	}
}
