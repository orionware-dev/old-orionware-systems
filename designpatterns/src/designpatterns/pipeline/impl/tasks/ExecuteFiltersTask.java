package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineLifecycleService;
import designpatterns.pipeline.impl.PipelineLifecycleServiceImpl;

public class ExecuteFiltersTask extends DesignPatternsObject implements DesignPatternsTask
{
    public Object run(AbstractPipeline pipeline)
    {
        PipelineLifecycleService pipelineLifecycleService = new PipelineLifecycleServiceImpl();
        pipelineLifecycleService.registerPipeline(pipeline);
        return pipelineLifecycleService.executePipelineFilters();
    }
}