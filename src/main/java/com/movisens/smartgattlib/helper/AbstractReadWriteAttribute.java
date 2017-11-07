package com.movisens.smartgattlib.helper;


public abstract class AbstractReadWriteAttribute extends AbstractAttribute
{
    @Override
    public boolean isReadable()
    {
        return true;
    }
    
    @Override
    public boolean isWritable()
    {
        return true;
    }

}
