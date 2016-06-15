package designpatterns.services.pipeline.impl;

import core.dependencyinjection.Injector;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.tasks.CreateEmptyFilterTask;
import designpatterns.services.pipeline.impl.tasks.CreateFilterTask;
import designpatterns.services.pipeline.impl.tasks.ExecuteFilterTask;
import designpatterns.services.pipeline.impl.tasks.IsCustomFunctionTask;

public class PipelineFilterServiceImpl extends DesignPatternsServicesObject implements PipelineFilterService
{
    private CreateEmptyFilterTask createEmptyFilterTask;
    private CreateFilterTask createFilterTask;
    private IsCustomFunctionTask isCustomFunctionTask;
    private ExecuteFilterTask executeFilterTask;
    
    
    public PipelineFilterServiceImpl()
    {
        
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


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.CreateEmptyFilterTask")
    private void setCreateEmptyFilterTask(CreateEmptyFilterTask createEmptyFilterTask)
    {
        this.createEmptyFilterTask = createEmptyFilterTask;
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.CreateFilterTask")
    private void setCreateFilterTask(CreateFilterTask createFilterTask)
    {
        this.createFilterTask = createFilterTask;
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.IsCustomFunctionTask")
    private void setIsCustomFunctionTask(IsCustomFunctionTask isCustomFunctionTask)
    {
        this.isCustomFunctionTask = isCustomFunctionTask;
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.tasks.ExecuteFilterTask")
    private void setExecuteFilterTask(ExecuteFilterTask executeFilterTask)
    {
        this.executeFilterTask = executeFilterTask;
    }
}