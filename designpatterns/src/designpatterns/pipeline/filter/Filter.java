package designpatterns.pipeline.filter;

import designpatterns.pipeline.AbstractFilter;

public class Filter extends AbstractFilter
{
    public Filter()
    {

    }


    public Filter(Object functionToExecute, String methodToRun, Object... functionParameters)
    {
        super(functionToExecute, methodToRun, functionParameters);
    }
}