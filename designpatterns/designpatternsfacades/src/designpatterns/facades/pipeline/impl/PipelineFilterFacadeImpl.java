package designpatterns.facades.pipeline.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.pipeline.PipelineFilterFacade;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.PipelineFilterServiceImpl;

public class PipelineFilterFacadeImpl extends DesignPatternsFacadesObject implements PipelineFilterFacade
{
    private PipelineFilterService pipelineFilterService;
    
    
    public PipelineFilterFacadeImpl()
    {
        this.pipelineFilterService = new PipelineFilterServiceImpl();
    }


    @Override
    public AbstractFilter createEmptyFilter()
    {
        return pipelineFilterService.createEmptyFilter();
    }


    @Override
    public AbstractFilter createFilter(Object function, String methodToRun, Object... functionParameters)
    {
        return pipelineFilterService.createFilter(function, methodToRun, functionParameters);
    }


    @Override
    public Object executeFilter(AbstractFilter filter, Object functionInput)
    {
        return pipelineFilterService.executeFilter(filter, functionInput);
    }


    @Override
    public AbstractFilter isCustomFunction(AbstractFilter filter)
    {
        return pipelineFilterService.isCustomFunction(filter);
    }
}