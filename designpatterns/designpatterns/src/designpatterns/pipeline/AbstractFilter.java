package designpatterns.pipeline;

import core.runnables.OrionExecutable;
import designpatterns.DesignPatternsObject;

public abstract class AbstractFilter extends DesignPatternsObject
{
    private OrionExecutable function;
    private Object functionResult;
    
    
    public AbstractFilter()
    {
        
    }
    
    
    public AbstractFilter(OrionExecutable functionToExecute)
    {
        setFunction(functionToExecute);
    }
    
    
    public void addFunction(OrionExecutable functionToExecute)
    {
        setFunction(functionToExecute);
    }
    
    
    public abstract void run();


    protected OrionExecutable getFunction()
    {
        return this.function;
    }


    protected void setFunction(OrionExecutable function)
    {
        this.function = function;
    }


    public Object getFunctionResult()
    {
        return this.functionResult;
    }


    protected void setFunctionResult(Object functionResult)
    {
        this.functionResult = functionResult;
    }
}