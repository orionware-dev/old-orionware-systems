package designpatterns.pipeline;

import core.orion.OrionObject;

public abstract class AbstractFilter extends OrionObject
{
    protected OrionObject function;
    protected Object functionResult;
    
    
    public abstract void executeFilter();
    
    
    public Object getFunctionResult()
    {
        return this.functionResult;
    }
}