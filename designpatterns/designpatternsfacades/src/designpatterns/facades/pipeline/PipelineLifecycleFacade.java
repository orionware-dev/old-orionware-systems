package designpatterns.facades.pipeline;

import designpatterns.DesignPatternsFacade;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineLifecycleFacade extends DesignPatternsFacade
{
    public void registerPipeline(AbstractPipeline pipeline);
    
    
    public Object executePipelineFilters();
}