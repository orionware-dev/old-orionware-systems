package designpatterns.pipeline.impl;

import core.runnables.OrionExecutable;
import core.runnables.functions.OrionFunction;
import core.services.OrionTask;
import designpatterns.pipeline.AbstractFilter;

public class Filter extends AbstractFilter
{
    public Filter()
    {
        
    }
    
    
    public Filter(OrionExecutable functionToExecute)
    {
        super(functionToExecute);
    }
    
    /*instead of manually checking the instanceof, use configuration/Pipeline.prop in which I explicitly
    declare the class types OrionExecutable and OrionTask and use that config to do
    the checking in a loop with stream() like: for each class type, if function instanceof thisClassType,
    return ((OrionExecutable)function).run();*/
    
    @Override
    public void run()
    {
        /*if(getFunction() instanceof OrionExecutable)
        {
            setFunctionResult(((OrionExecutable)getFunction()).run());
        }
        else if(getFunction() instanceof OrionTask)
        {
            setFunctionResult(((OrionTask)getFunction()).run());
        }*/
        
        //return null;
    }
}