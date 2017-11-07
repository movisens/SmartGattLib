package com.movisens.smartgattlib.helper;

public abstract class AbstractWriteAttribute extends AbstractAttribute
{

    @Override
    public boolean isReadable()
    {
        return false;
    }

    @Override
    public boolean isWritable()
    {
        return true;
    }

}
