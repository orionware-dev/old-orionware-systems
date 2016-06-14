package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineLifecycleService extends DesignPatternsService
{
    public void registerPipeline(AbstractPipeline pipeline);
    
    
    public Object executePipelineFilters();
}