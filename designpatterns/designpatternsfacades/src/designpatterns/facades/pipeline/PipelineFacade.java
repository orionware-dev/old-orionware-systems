package designpatterns.facades.pipeline;

import designpatterns.DesignPatternsFacade;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;

public interface PipelineFacade extends DesignPatternsFacade
{
    public AbstractPipeline createEmptyPipeline();


    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter);


    public Object executeFilters(AbstractPipeline pipeline);
}