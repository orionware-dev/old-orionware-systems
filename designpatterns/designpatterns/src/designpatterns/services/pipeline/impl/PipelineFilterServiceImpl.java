package designpatterns.services.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.services.pipeline.impl.tasks.CreateFilterTask;
import designpatterns.services.pipeline.impl.tasks.ExecuteFilterTask;
import designpatterns.services.pipeline.impl.tasks.IsCustomFunctionTask;

public class PipelineFilterServiceImpl extends DesignPatternsObject implements PipelineFilterService
{
    private CreateEmptyFilterTask createEmptyFilterTask;
    private CreateFilterTask createFilterTask;
    private IsCustomFunctionTask isCustomFunctionTask;
    private ExecuteFilterTask executeFilterTask;
    
    
    public PipelineFilterServiceImpl()
    {
        this.createEmptyFilterTask = new CreateEmptyFilterTask();
        this.createFilterTask = new CreateFilterTask();
        this.isCustomFunctionTask = new IsCustomFunctionTask();
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
    public AbstractFilter isCustomFunction(AbstractFilter filter)
    {
        return isCustomFunctionTask.run(filter);
    }
    
    
    @Override
    public Object executeFilter(AbstractFilter filter, Object functionInput)
    {
        return executeFilterTask.run(filter, functionInput);
    }
}