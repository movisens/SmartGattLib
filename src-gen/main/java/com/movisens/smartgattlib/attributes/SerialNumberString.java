package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

public class SerialNumberString extends AbstractReadAttribute implements PlainTextAttribute
{

	public static final Characteristic<SerialNumberString> CHARACTERISTIC = Characteristics.SERIAL_NUMBER_STRING;
	
	private String serial_Number;
	
	public String getSerial_Number()
	{
		return serial_Number;
	}
	
	public String getSerial_NumberUnit()
	{
		return "";
	}
	
	public SerialNumberString(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		serial_Number = bb.getString();
	}

	@Override
	public Characteristic<SerialNumberString> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getSerial_Number().toString();
	}
}
