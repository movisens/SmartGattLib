package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;
import com.movisens.smartgattlib.helper.PlainTextAttribute;

public class FirmwareRevisionString extends AbstractReadAttribute implements PlainTextAttribute
{

	public static final Characteristic<FirmwareRevisionString> CHARACTERISTIC = Characteristics.FIRMWARE_REVISION_STRING;
	
	private String firmware_Revision;
	
	public String getFirmware_Revision()
	{
		return firmware_Revision;
	}
	
	public String getFirmware_RevisionUnit()
	{
		return "";
	}
	
	public FirmwareRevisionString(byte[] data)
	{
		this.data = data;
		GattByteBuffer bb = GattByteBuffer.wrap(data);
		firmware_Revision = bb.getString();
	}

	@Override
	public Characteristic<FirmwareRevisionString> getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return getFirmware_Revision().toString();
	}
}
