package designpatterns.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineLifecycleService;
import designpatterns.pipeline.PipelineService;
import designpatterns.pipeline.pipe.Pipeline;

public class PipelineServiceImpl extends DesignPatternsObject implements PipelineService
{
    public PipelineServiceImpl()
    {
        
    }
    
    
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