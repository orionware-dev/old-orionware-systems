package designpatterns.pipeline;

import core.OrionObject;
import designpatterns.DesignPatternsObject;

public abstract class AbstractFilter extends DesignPatternsObject
{
    protected OrionObject function;
    protected Object functionResult;
    
    
    public abstract void executeFilter();
    
    
    public Object getFunctionResult()
    {
        return this.functionResult;
    }
}