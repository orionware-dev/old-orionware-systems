package designpatterns.pipeline.impl.tasks;

import dependencyinjection.annotation.InjectorImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineLifecycleService;

public class ExecuteFiltersTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private PipelineLifecycleService pipelineLifecycleService;
    
    
    public Object run(AbstractPipeline pipeline)
    {
        pipelineLifecycleService.registerPipeline(pipeline);
        return pipelineLifecycleService.executePipelineFilters();
    }
}