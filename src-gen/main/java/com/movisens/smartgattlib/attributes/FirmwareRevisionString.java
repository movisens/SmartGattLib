package com.movisens.smartgattlib.attributes;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.helper.AbstractReadAttribute;
import com.movisens.smartgattlib.helper.Characteristic;
import com.movisens.smartgattlib.helper.GattByteBuffer;

public class FirmwareRevisionString extends AbstractReadAttribute
{

	public static final Characteristic CHARACTERISTIC = Characteristics.FIRMWARE_REVISION_STRING;
	
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
	public Characteristic getCharacteristic()
	{
		return CHARACTERISTIC;
	}

	@Override
	public String toString()
	{
		return "Firmware Revision String: " + "firmware_Revision = " + getFirmware_Revision();
	}
}
