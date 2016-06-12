package designpatterns.pipeline;

import core.runnables.consumers.OrionConsumer;
import core.runnables.functions.OrionFunction;
import designpatterns.DesignPatternsObject;

public abstract class AbstractFilter extends DesignPatternsObject
{
    private Object function;
    private Class<?> functionClass;
    private String methodToRun;
    private Object[] functionParameters;
    private Object functionResult;
    private boolean isCustomFunction;


    public AbstractFilter()
    {

    }


    public AbstractFilter(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        setMethodToRun(methodToRun);
        setFunction(functionToExecute);
        setFunctionClass(functionToExecute.getClass());
        setFunctionParameters(functionParameters);
        findIfFunctionIsCustom();
    }


    public void addFunction(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        setMethodToRun(methodToRun);
        setFunction(functionToExecute);
        setFunctionClass(functionToExecute.getClass());
        setFunctionParameters(functionParameters);
        findIfFunctionIsCustom();
    }
    
    
    private void findIfFunctionIsCustom()
    {
        if(getFunction() instanceof OrionConsumer || getFunction() instanceof OrionFunction)
        {
            setCustomFunction(false);
        }
        else
        {
            setCustomFunction(true);
        }
    }


    public Object getFunction()
    {
        return this.function;
    }


    protected void setFunction(Object function)
    {
        this.function = function;
    }


    public Object getFunctionResult()
    {
        return this.functionResult;
    }


    public void setFunctionResult(Object functionResult)
    {
        this.functionResult = functionResult;
    }


    public Object[] getFunctionParameters()
    {
        return this.functionParameters;
    }


    public void setFunctionParameters(Object[] functionParameters)
    {
        this.functionParameters = functionParameters;
    }


    public Class<?> getFunctionClass()
    {
        return this.functionClass;
    }


    public void setFunctionClass(Class<?> functionClass)
    {
        this.functionClass = functionClass;
    }


    public String getMethodToRun()
    {
        return this.methodToRun;
    }


    public void setMethodToRun(String methodToRun)
    {
        this.methodToRun = methodToRun;
    }


    public boolean isCustomFunction()
    {
        return this.isCustomFunction;
    }


    public void setCustomFunction(boolean isCustomFunction)
    {
        this.isCustomFunction = isCustomFunction;
    }
}