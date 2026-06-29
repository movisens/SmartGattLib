package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

/**
 * The current charge level of a battery. 100% represents fully charged while 0% represents fully discharged.
 */
public class BatteryLevel extends AbstractReadAttribute
{

	public static final Characteristic<BatteryLevel> CHARACTERISTIC = Characteristics.BATTERY_LEVEL;
	
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
		level = (double) bb.getUint8();
	}

	@Override
	public Characteristic<BatteryLevel> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getLevel().toString() + getLevelUnit();
	}
}
