package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineFilterService;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;

public class ExecutePipelineFiltersTask extends DesignPatternsObject implements DesignPatternsTask
{
    public Object run(AbstractPipeline pipeline)
    {
        Object pipelineResult = null;
        PipelineFilterService pipelineFilterService = new PipelineFilterServiceImpl();

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