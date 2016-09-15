package designpatterns.pipeline.impl;

import dependencyinjection.annotation.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.PipelineFilterService;
import designpatterns.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.pipeline.impl.tasks.CreateEmptyPipelineTask;
import designpatterns.pipeline.impl.tasks.CreateFilterTask;
import designpatterns.pipeline.impl.tasks.ExecuteFilterTask;
import designpatterns.pipeline.impl.tasks.SetIsCustomFunctionTask;

public class PipelineFilterServiceImpl extends DesignPatternsObject implements PipelineFilterService
{
    @Injector
    private CreateEmptyFilterTask createEmptyFilterTask;
    @Injector
    private CreateFilterTask createFilterTask;
    @Injector
    private SetIsCustomFunctionTask setIsCustomFunctionTask;
    @Injector
    private ExecuteFilterTask executeFilterTask;
    
    
    @Override
    public AbstractFilter createEmptyFilter()
    {
        return createEmptyFilterTask.run();
    }


    @Override
    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters)
    {
        return createFilterTask.run(function, methodToRun, functionParameters);
    }


    @Override
    public AbstractFilter setIsCustomFunction(AbstractFilter filter)
    {
        return setIsCustomFunctionTask.run(filter);
    }


    @Override
    public Object executeFilter(AbstractFilter filter, Object functionInput)
    {
        return executeFilterTask.run(filter, functionInput);
    }
}