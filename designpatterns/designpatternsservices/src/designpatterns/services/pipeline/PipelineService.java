package designpatterns.services.pipeline;

import designpatterns.DesignPatternsService;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineService extends DesignPatternsService
{
    public AbstractPipeline createEmptyPipeline(boolean feedForwardTheResult);


    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter);


    public Object executeFilters(AbstractPipeline pipeline);
}