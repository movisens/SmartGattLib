package com.movisens.smartgattlib.helper;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.UUID;

public class GattByteBuffer
{

    public static GattByteBuffer allocate(int i)
    {
        GattByteBuffer result = new GattByteBuffer();
        result.buffer = ByteBuffer.allocate(i);
        result.buffer.order(ByteOrder.LITTLE_ENDIAN);
        return result;
    }

    public static GattByteBuffer wrap(byte[] byteArray)
    {
        GattByteBuffer result = new GattByteBuffer();
        result.buffer = ByteBuffer.wrap(byteArray);
        result.buffer.order(ByteOrder.LITTLE_ENDIAN);
        return result;
    }

    private ByteBuffer buffer;

    public byte[] array()
    {
        return buffer.array();
    }

    public final int capacity()
    {
        return buffer.capacity();
    }

    public void getInt8(byte[] value, int i, int j)
    {
        buffer.get(value, i, j);
    }

    public void getUint8(short[] value, int offset, int length)
    {
        for (int i = 0; i < length; i++)
        {
            value[i + offset] = getUint8();
        }
    }

    public Boolean getBoolean()
    {
        if (buffer.get() == (byte) 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Float getFloat32()
    {
        return buffer.getFloat();
    }

    public Short getInt16()
    {
        return buffer.getShort();
    }

    public Integer getInt32()
    {
        return buffer.getInt();
    }

    public Long getInt64()
    {
        return buffer.getLong();
    }

    public Byte getInt8()
    {
        return buffer.get();
    }

    public String getString()
    {
        String result = "";
        byte c;

        while (buffer.hasRemaining() && ((c = buffer.get()) != 0))
        {
            result += (char) c;
        }

        return result;
    }

    public Integer getUint16()
    {
        int result = buffer.getShort();
        if (result < 0)
        {
            result += ((int) 1) << 16;
        }
        return result;
    }

    public Long getUint32()
    {
        long result = buffer.getInt();
        if (result < 0)
        {
            result += ((long) 1) << 32;
        }
        return result;
    }

    public Short getUint8()
    {
        short result = buffer.get();
        if (result < 0)
        {
            result += ((short) 1) << 8;
        }
        return result;
    }

    public GattByteBuffer position(int i)
    {
        buffer.position(i);
        return this;
    }

    public GattByteBuffer putUint8(short[] value, int offset, int length)
    {
        for (int i = 0; i < length; i++)
        {
            putUint8(value[i + offset]);
        }
        return this;
    }

    public GattByteBuffer putInt8(byte[] value, int i, int j)
    {
        buffer.put(value, i, j);
        return this;
    }

    public GattByteBuffer putBoolean(boolean doEnable)
    {
        if (doEnable)
        {
            buffer.put((byte) 1);
        }
        else
        {
            buffer.put((byte) 0);
        }
        return this;
    }

    public GattByteBuffer putFloat32(Float value)
    {
        buffer.putFloat(value);
        return this;
    }

    public GattByteBuffer putInt16(short value)
    {
        buffer.putShort(value);
        return this;
    }

    public GattByteBuffer putInt32(int value)
    {
        buffer.putInt(value);
        return this;
    }

    public GattByteBuffer putInt64(long value)
    {
        buffer.putLong(value);
        return this;
    }

    public GattByteBuffer putInt8(byte value)
    {
        buffer.put(value);
        return this;
    }

    public GattByteBuffer putString(String value)
    {
        buffer.put(value.getBytes());
        buffer.put((byte) 0);
        return this;
    }

    public GattByteBuffer putUint16(int value)
    {
        buffer.putShort((short) value);
        return this;
    }

    public GattByteBuffer putUint32(long value)
    {
        buffer.putInt((int) value);
        return this;
    }

    public GattByteBuffer putUint8(short value)
    {
        buffer.put((byte) value);
        return this;
    }

    public GattByteBuffer rewind()
    {
        buffer.rewind();
        return this;
    }

    public boolean hasRemaining()
    {
        return buffer.hasRemaining();
    }

    public void putStime(Date date)
    {
        putUint32(date.getTime()/1000);        
    }

    public Date getStime()
    {
        return new Date(getUint32()*1000);
    }

    public void putMstime(Date date)
    {
        putInt64(date.getTime());        
    }

    public Date getMstime()
    {
        return new Date(getInt64());
    }

    public void putTimezone(String zoneId)
    {
        String stzs = TimeZoneUtil.toShortTimeZone(zoneId);
        putString(stzs);
    }
 
    public String getTimezone()
    {
       String stzs = getString();
       String ltzs = TimeZoneUtil.toLongTimeZone(stzs);
       return ltzs;
    }

    public UUID getUuid()
    {
        int length = buffer.remaining();
        byte[] data = new byte[length];
        buffer.get(data);
        
        String uuidString = "";
        
        for (int i = data.length - 1; i >= 0; i--)
        {
            if (i == 5 || i == 7 || i == 9 || i == 11)
            {
                uuidString += "-";
            }
            uuidString += String.format("%02x", data[i]);
        }

        return UuidObject.stringToUuid(uuidString);
    }
}