package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Height extends AbstractReadWriteAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.HEIGHT;
	
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
		this.heigt = heigt;
		GattByteBuffer bb = GattByteBuffer.allocate(2);
		bb.putUint16(new Double(heigt / 0.01).intValue());
		this.data = bb.array();
	}

	public Height(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		heigt = ((double)bb.getUint16()) * 0.01;
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Height: " + "heigt = " + getHeigt() + getHeigtUnit();
	}
}
