package com.movisens.smartgattlib.helper;

import static org.junit.Assert.assertTrue;

import java.time.ZoneId;
import java.util.Set;

import org.junit.Test;


public class GattByteBufferTest
{

    @Test
    public void testPutTimeZone()
    {
        Set<String> zIds = ZoneId.getAvailableZoneIds();
        for (String zId : zIds)
        {
            GattByteBuffer bb = GattByteBuffer.allocate(20);

            bb.putTimezone(zId);
            bb.rewind();
            String gtz = bb.getTimezone();
            assertTrue(gtz.equals(zId));
        }
    }

}
