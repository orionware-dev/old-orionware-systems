package designpatterns.pipeline.services.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.Pipeline;
import designpatterns.pipeline.services.PipelineService;

public class PipelineServiceImpl extends DesignPatternsObject implements PipelineService
{
    private AbstractPipeline pipeline;
    
    
    @Override
    public AbstractPipeline createPipeline()
    {
        pipeline = new Pipeline();
        return pipeline;
    }
    
    
    @Override
    public Object executeFilters()
    {
        return null;
    }
}