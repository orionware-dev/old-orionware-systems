package designpatterns.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.PipelineFilterService;
import designpatterns.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.pipeline.impl.tasks.CreateFilterTask;
import designpatterns.pipeline.impl.tasks.ExecuteFilterTask;
import designpatterns.pipeline.impl.tasks.SetIsCustomFunctionTask;

public class PipelineFilterServiceImpl extends DesignPatternsObject implements PipelineFilterService
{
    @Override
    public AbstractFilter createEmptyFilter()
    {
        return new CreateEmptyFilterTask().run();
    }


    @Override
    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters)
    {
        return new CreateFilterTask().run(function, methodToRun, functionParameters);
    }


    @Override
    public AbstractFilter setIsCustomFunction(AbstractFilter filter)
    {
        return new SetIsCustomFunctionTask().run(filter);
    }


    @Override
    public Object executeFilter(AbstractFilter filter, Object functionInput)
    {
        return new ExecuteFilterTask().run(filter, functionInput);
    }
}