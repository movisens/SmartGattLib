package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

public class ModelNumberString extends AbstractReadAttribute implements PlainTextAttribute
{

	public static final Characteristic<ModelNumberString> CHARACTERISTIC = Characteristics.MODEL_NUMBER_STRING;
	
	private String model_Number;
	
	public String getModel_Number()
	{
		return model_Number;
	}
	
	public String getModel_NumberUnit()
	{
		return "";
	}
	
	public ModelNumberString(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		model_Number = bb.getString();
	}

	@Override
	public Characteristic<ModelNumberString> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getModel_Number().toString();
	}
}
