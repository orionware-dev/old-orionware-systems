package designpatterns.facades.pipeline.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.pipeline.PipelineLifecycleFacade;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineLifecycleService;

public class PipelineLifecycleFacadeImpl extends DesignPatternsFacadesObject implements PipelineLifecycleFacade
{
    private PipelineLifecycleService pipelineLifecycleService;


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


    @Injector(ID = "designpatterns.services.pipeline.impl.PipelineLifecycleServiceImpl")
    private void setPipelineLifecycleService(PipelineLifecycleService pipelineLifecycleService)
    {
        this.pipelineLifecycleService = pipelineLifecycleService;
    }
}