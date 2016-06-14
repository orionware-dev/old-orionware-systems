package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.pipe.Pipeline;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineLifecycleService;
import designpatterns.services.pipeline.PipelineService;

public class PipelineServiceImpl extends DesignPatternsServicesObject implements PipelineService
{
    @Override
    public AbstractPipeline createEmptyPipeline(boolean feedForwardTheResult)
    {
        return new Pipeline(feedForwardTheResult);
    }


    @Override
    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter)
    {
        pipeline.addFilter(filter);
    }


    @Override
    public Object executeFilters(AbstractPipeline pipeline)
    {
        PipelineLifecycleService pipelineLifecycleService = new PipelineLifecycleServiceImpl();
        pipelineLifecycleService.registerPipeline(pipeline);
        return pipelineLifecycleService.executePipelineFilters();
    }
}