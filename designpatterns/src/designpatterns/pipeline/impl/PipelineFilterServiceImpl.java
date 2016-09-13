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
    private CreateEmptyFilterTask createEmptyFilterTask;
    private CreateFilterTask createFilterTask;
    private SetIsCustomFunctionTask setIsCustomFunctionTask;
    private ExecuteFilterTask executeFilterTask;


    public PipelineFilterServiceImpl()
    {
        this.createEmptyFilterTask = new CreateEmptyFilterTask();
        this.createFilterTask = new CreateFilterTask();
        this.setIsCustomFunctionTask = new SetIsCustomFunctionTask();
        this.executeFilterTask = new ExecuteFilterTask();
    }


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