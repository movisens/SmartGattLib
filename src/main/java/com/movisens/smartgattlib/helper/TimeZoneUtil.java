package com.movisens.smartgattlib.helper;

import java.util.HashMap;
import java.util.Map.Entry;

public class TimeZoneUtil
{

    private static HashMap<String, String> getTransformMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("ARG", "America/Argentina");
        map.put("AM", "America");
        map.put("EU", "Europe");
        map.put("AU", "Australia");
        map.put("ANT", "Antarctica");
        map.put("ND", "North_Dakota");
        map.put("KY", "Kentucky");
        map.put("/IN", "/Indiana");
        map.put("ATC", "Atlantic");
        map.put("AFR", "Africa");
        map.put("PFC", "Pacific");
        return map;
    }

    public static String toLongTimeZone(String timeZoneString)
    {
        String id = timeZoneString;
        HashMap<String, String> map = getTransformMap();

        for (Entry<String, String> e : map.entrySet())
        {
            id = id.replaceAll(e.getKey(), e.getValue());
        }

        return id;
    }

    public static String toShortTimeZone(String timeZoneString)
    {
        String id = timeZoneString;
        HashMap<String, String> map = getTransformMap();

        for (Entry<String, String> e : map.entrySet())
        {
            id = id.replaceAll(e.getValue(), e.getKey());
        }

        return id;
    }
}
