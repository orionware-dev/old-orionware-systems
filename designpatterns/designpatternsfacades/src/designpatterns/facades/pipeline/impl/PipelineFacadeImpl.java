package designpatterns.facades.pipeline.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.pipeline.PipelineFacade;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineService;

public class PipelineFacadeImpl extends DesignPatternsFacadesObject implements PipelineFacade
{
    private PipelineService pipelineService;


    @Override
    public AbstractPipeline createEmptyPipeline(boolean feedForwardTheResult)
    {
        return pipelineService.createEmptyPipeline(feedForwardTheResult);
    }


    @Override
    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter)
    {
        pipelineService.addFilterToPipeline(pipeline, filter);
    }


    @Override
    public Object executeFilters(AbstractPipeline pipeline)
    {
        return pipelineService.executeFilters(pipeline);
    }


    @Injector(ID = "designpatterns.services.pipeline.impl.PipelineServiceImpl")
    private void setPipelineService(PipelineService pipelineService)
    {
        this.pipelineService = pipelineService;
    }
}