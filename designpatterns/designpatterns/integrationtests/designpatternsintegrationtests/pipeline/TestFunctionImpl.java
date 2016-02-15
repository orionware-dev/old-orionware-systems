package designpatternsintegrationtests.pipeline;

import core.functions.OrionAbstractFunction;

public class TestFunctionImpl extends OrionAbstractFunction implements TestFunction
{
    private String aString;
    
    
    public TestFunctionImpl(String aString)
    {
        this.aString = aString;
    }
    
    
    @Override
    public Object functionName()
    {
        System.out.println("aString = " + aString);
        return "aString = " + aString;
    }


    @Override
    public Object run()
    {
        return functionName();
    }
}