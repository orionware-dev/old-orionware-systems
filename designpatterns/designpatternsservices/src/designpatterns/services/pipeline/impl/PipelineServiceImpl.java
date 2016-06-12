package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.pipe.Pipeline;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineService;

public class PipelineServiceImpl extends DesignPatternsServicesObject implements PipelineService
{
    @Override
    public AbstractPipeline createEmptyPipeline()
    {
        return new Pipeline();
    }


    @Override
    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter)
    {
        pipeline.addFilter(filter);
    }


    @Override
    public Object executeFilters(AbstractPipeline pipeline)
    {
        Object pipelineResult = null;
        PipelineFilterService pipelineFilterService = new PipelineFilterServiceImpl();

        for(AbstractFilter filter : pipeline.getFiltersList())
        {
            pipelineResult = pipelineFilterService.executeFilter(filter);
            pipeline.setLastFunctionResult(pipelineResult);
        }

        return pipelineResult;
    }
}