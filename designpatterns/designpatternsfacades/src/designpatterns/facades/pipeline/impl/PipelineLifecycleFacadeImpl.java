package designpatterns.facades.pipeline.impl;

import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.pipeline.PipelineFacade;
import designpatterns.facades.pipeline.PipelineLifecycleFacade;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineLifecycleService;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineLifecycleServiceImpl;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;

public class PipelineLifecycleFacadeImpl extends DesignPatternsFacadesObject implements PipelineLifecycleFacade
{
    private PipelineLifecycleService pipelineLifecycleService;


    public PipelineLifecycleFacadeImpl()
    {
        this.pipelineLifecycleService = new PipelineLifecycleServiceImpl();
    }


    @Override
    public void registerPipeline(AbstractPipeline pipeline)
    {
        pipelineLifecycleService.registerPipeline(pipeline);
    }


    @Override
    public Object executePipelineFilters()
    {
        return pipelineLifecycleService.executePipelineFilters();
    }
}