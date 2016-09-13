package designpatterns.pipeline;

import designpatterns.DesignPatternsService;

public interface PipelineLifecycleService extends DesignPatternsService
{
    public void registerPipeline(AbstractPipeline pipeline);
    
    
    public Object executePipelineFilters();
}