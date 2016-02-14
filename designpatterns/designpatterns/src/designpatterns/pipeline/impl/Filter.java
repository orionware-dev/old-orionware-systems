package designpatterns.pipeline.impl;

import core.general.functions.OrionAbstractFunction;
import core.general.services.OrionTask;
import designpatterns.pipeline.AbstractFilter;

public class Filter extends AbstractFilter
{
    public Filter(OrionAbstractFunction functionToExecute)
    {
        this.function = functionToExecute;
    }
    
    
    @Override
    public void executeFilter()
    {
        if(function instanceof OrionAbstractFunction)
        {
            this.functionResult = ((OrionAbstractFunction)function).execute();
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