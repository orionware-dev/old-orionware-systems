package designpatterns.pipeline;

import designpatterns.DesignPatternsObject;

public abstract class AbstractFilter extends DesignPatternsObject
{
    private boolean isFunctionAProcedure;
    private Object function;
    private Class<?> functionClass;
    private String methodToRun;
    private Object[] functionParameters;
    private Object functionResult;
    
    
    public AbstractFilter()
    {
        
    }
    
    
    public AbstractFilter(boolean isFunctionAProcedure, Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        setFunctionAProcedure(isFunctionAProcedure);
        setMethodToRun(methodToRun);
        setFunction(functionToExecute);
        setFunctionClass(functionToExecute.getClass());
        setFunctionParameters(functionParameters);
    }
    
    
    public void addFunction(boolean isFunctionAProcedure, Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        setFunctionAProcedure(isFunctionAProcedure);
        setMethodToRun(methodToRun);
        setFunction(functionToExecute);
        setFunctionClass(functionToExecute.getClass());
        setFunctionParameters(functionParameters);
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


    public boolean isFunctionAProcedure()
    {
        return this.isFunctionAProcedure;
    }


    public void setFunctionAProcedure(boolean isFunctionAProcedure)
    {
        this.isFunctionAProcedure = isFunctionAProcedure;
    }


    public String getMethodToRun()
    {
        return this.methodToRun;
    }


    public void setMethodToRun(String methodToRun)
    {
        this.methodToRun = methodToRun;
    }
}