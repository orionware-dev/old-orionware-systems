package designpatterns.pipeline.services;

import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.DesignPatternsService;

public interface PipelineService extends DesignPatternsService
{
    public abstract AbstractPipeline createPipeline();
    
    
    public abstract Object executeFilters();
}