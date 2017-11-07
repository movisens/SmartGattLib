package com.movisens.smartgattlib.attributes;

public enum EnumGender
{
	MALE                          ((short)0, "Male"),
	FEMALE                        ((short)1, "Female"),
	UNSPECIFIED                   ((short)2, "Unspecified"),
	INVALID                       ((short)3, "invalid");

	private final short value;
	private final String name;

	EnumGender(short value, String name)
	{
		this.value = value;
		this.name = name;
	}

	public short getValue()
	{
		return value;
	}
	
	public String getName()
	{
		return name;
	}

	public static EnumGender getByValue(short value)
	{
		switch (value)
		{
			case 0:
				return EnumGender.MALE;
			case 1:
				return EnumGender.FEMALE;
			case 2:
				return EnumGender.UNSPECIFIED;
			default:
				return EnumGender.INVALID;
		}
	}
	
	@Override
	public String toString()
	{
		return name;
	}
}
