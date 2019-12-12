package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Height extends AbstractReadWriteAttribute
{

	public static final Characteristic<Height> CHARACTERISTIC = Characteristics.HEIGHT;
	
	private Double heigt;
	
	public Double getHeigt()
	{
		return heigt;
	}
	
	public String getHeigtUnit()
	{
		return "m";
	}
	
	public Height(Double heigt)
	{
		if(heigt<0.0)
		{
			throw new RuntimeException("heigt out of range! Min value is 0.0");
		}
		if(heigt>3.0)
		{
			throw new RuntimeException("heigt out of range! Max value is 3.0");
		}
		this.heigt = heigt;
		GattByteBuffer bb = GattByteBuffer.allocate(2);
		bb.putUint16(new Long(Math.round(heigt / 0.01)).intValue());
		this.data = bb.array();
	}

	public Height(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		heigt = ((double)bb.getUint16()) * 0.01;
	}

	@Override
	public Characteristic<Height> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getHeigt().toString() + getHeigtUnit();
	}
}
