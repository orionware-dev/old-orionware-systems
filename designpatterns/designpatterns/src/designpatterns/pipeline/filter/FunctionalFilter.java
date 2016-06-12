package designpatterns.pipeline.filter;

import designpatterns.pipeline.AbstractFilter;

public class FunctionalFilter extends AbstractFilter
{
    public FunctionalFilter()
    {
        
    }
    
    
    public FunctionalFilter(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        super(false, functionToExecute, methodToRun, functionParameters);
    }
}