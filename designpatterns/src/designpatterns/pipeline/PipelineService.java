package designpatterns.pipeline;

import designpatterns.DesignPatternsService;

public interface PipelineService extends DesignPatternsService
{
    public AbstractPipeline createEmptyPipeline(boolean feedForwardTheResult);


    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter);


    public Object executeFilters(AbstractPipeline pipeline);
}