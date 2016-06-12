package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineService extends DesignPatternsService
{
    public AbstractPipeline createEmptyProceduralPipeline();
    
    
    public AbstractPipeline createEmptyFunctionalPipeline();
    
    
    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter);
    
    
    public Object executeFilters(AbstractPipeline pipeline);
}