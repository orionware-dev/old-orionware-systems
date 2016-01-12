package designpatterns.pipeline.services.impl;

import core.orion.OrionObject;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.Pipeline;
import designpatterns.pipeline.services.PipelineService;

public class PipelineServiceImpl extends OrionObject implements PipelineService
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