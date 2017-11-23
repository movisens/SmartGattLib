package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadWriteAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class Weight extends AbstractReadWriteAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.WEIGHT;
	
	private Double weight;
	
	public Double getWeight()
	{
		return weight;
	}
	
	public String getWeightUnit()
	{
		return "kg";
	}
	
	public Weight(Double weight)
	{
		if(weight<0.0)
		{
			throw new RuntimeException("weight out of range! Min value is 0.0");
		}
		if(weight>327.68)
		{
			throw new RuntimeException("weight out of range! Max value is 327.68");
		}
		this.weight = weight;
		GattByteBuffer bb = GattByteBuffer.allocate(2);
		bb.putUint16(new Double(weight / 0.005).intValue());
		this.data = bb.array();
	}

	public Weight(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		weight = ((double)bb.getUint16()) * 0.005;
	}

	@Override
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getWeight().toString() + getWeightUnit();
	}
}
