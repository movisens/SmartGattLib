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
            ZoneId ptz = ZoneId.of(zId);
            bb.putTimezone(ptz);
            bb.rewind();
            ZoneId gtz = bb.getTimezone();
            assertTrue(gtz.equals(ptz));
        }
    }

}
