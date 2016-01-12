package designpatterns.pipeline.services;

import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.DesignPatternService;

public interface PipelineService extends DesignPatternService
{
    public abstract AbstractPipeline createPipeline();
    
    
    public abstract Object executeFilters();
}