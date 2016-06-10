package designpatterns.services.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.Pipeline;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineService;

public class PipelineServiceImpl extends DesignPatternsServicesObject implements PipelineService
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