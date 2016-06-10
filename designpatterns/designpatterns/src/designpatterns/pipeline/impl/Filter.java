package designpatterns.pipeline.impl;

import core.runnables.functions.OrionFunction;
import core.services.OrionTask;
import designpatterns.pipeline.AbstractFilter;

public class Filter extends AbstractFilter
{
    public Filter(OrionFunction functionToExecute)
    {
        this.function = functionToExecute;
    }
    
    
    @Override
    public void executeFilter()
    {
        if(function instanceof OrionFunction)
        {
            this.functionResult = ((OrionFunction)function).execute();
        }
        else if(function instanceof OrionTask)
        {
            this.functionResult = ((OrionTask)function).execute();
        }
        
        /*if(function instanceof OrionAbstractFunction)
        {
            return ((OrionAbstractFunction)function).executeFunction();
        }
        else if(function instanceof OrionServiceTask)
        {
            return ((OrionServiceTask)function).execute();
        }*/
        
        //return null;
    }
}