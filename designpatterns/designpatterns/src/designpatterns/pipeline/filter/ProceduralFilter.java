package designpatterns.pipeline.filter;

import designpatterns.pipeline.AbstractFilter;

public class ProceduralFilter extends AbstractFilter
{
    public ProceduralFilter()
    {
        
    }
    
    
    public ProceduralFilter(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        super(true, functionToExecute, methodToRun, functionParameters);
    }
}