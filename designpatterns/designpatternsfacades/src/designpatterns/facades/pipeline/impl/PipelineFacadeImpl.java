package designpatterns.facades.pipeline.impl;

import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.pipeline.PipelineFacade;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;

public class PipelineFacadeImpl extends DesignPatternsFacadesObject implements PipelineFacade
{
    private PipelineService pipelineService;


    public PipelineFacadeImpl()
    {
        this.pipelineService = new PipelineServiceImpl();
    }


    @Override
    public AbstractPipeline createEmptyPipeline()
    {
        return pipelineService.createEmptyPipeline();
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
}