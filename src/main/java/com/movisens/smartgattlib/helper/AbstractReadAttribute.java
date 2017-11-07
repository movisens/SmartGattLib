package com.movisens.smartgattlib.helper;


public abstract class AbstractReadAttribute extends AbstractAttribute
{

    @Override
    public boolean isReadable()
    {
        return true;
    }

    @Override
    public boolean isWritable()
    {
        return false;
    }

}
