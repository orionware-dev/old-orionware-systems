package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;

public class CreateFilterTask extends DesignPatternsObject implements DesignPatternsTask
{
    public AbstractFilter run(Object function, String methodToRun, Object... functionParameters)
    {
        AbstractFilter filter = new Filter(function, methodToRun, functionParameters);
        return new SetIsCustomFunctionTask().run(filter);
    }
}