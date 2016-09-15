package designpatterns.pipeline.impl.tasks;

import dependencyinjection.annotation.InjectorImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineFilterService;

public class ExecutePipelineFiltersTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private PipelineFilterService pipelineFilterService;
    
    
    public Object run(AbstractPipeline pipeline)
    {
        Object pipelineResult = null;

        if(pipeline.isFeedForwardTheResult())
        {
            for(AbstractFilter filter : pipeline.getFilters())
            {
                pipelineResult = pipelineFilterService.executeFilter(filter, pipelineResult);
                pipeline.setLastFunctionResult(pipelineResult);
            }
        }
        else
        {
            for(AbstractFilter filter : pipeline.getFilters())
            {
                pipelineResult = pipelineFilterService.executeFilter(filter, null);
                pipeline.setLastFunctionResult(pipelineResult);
            }
        }

        return pipelineResult;
    }
}