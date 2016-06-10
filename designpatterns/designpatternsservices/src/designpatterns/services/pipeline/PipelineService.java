package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineService extends DesignPatternsService
{
    public abstract AbstractPipeline createPipeline();
    
    
    public abstract Object executeFilters();
}