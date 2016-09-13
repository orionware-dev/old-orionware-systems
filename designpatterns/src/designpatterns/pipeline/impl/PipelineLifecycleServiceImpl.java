package designpatterns.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineFilterService;
import designpatterns.pipeline.PipelineLifecycleService;

public class PipelineLifecycleServiceImpl extends DesignPatternsObject implements PipelineLifecycleService
{
    private AbstractPipeline pipeline;
    
    
    public PipelineLifecycleServiceImpl()
    {
        
    }
    
    
    @Override
    public void registerPipeline(AbstractPipeline pipeline)
    {
        setPipeline(pipeline);
    }
    
    
    @Override
    public Object executePipelineFilters()
    {
        Object pipelineResult = null;
        PipelineFilterService pipelineFilterService = new PipelineFilterServiceImpl();
        
        if(pipeline.isFeedForwardTheResult())
        {
            for(AbstractFilter filter : getPipeline().getFilters())
            {
                pipelineResult = pipelineFilterService.executeFilter(filter, pipelineResult);
                getPipeline().setLastFunctionResult(pipelineResult);
            }
        }
        else
        {
            for(AbstractFilter filter : getPipeline().getFilters())
            {
                pipelineResult = pipelineFilterService.executeFilter(filter, null);
                getPipeline().setLastFunctionResult(pipelineResult);
            }
        }
        
        return pipelineResult;
    }


    public AbstractPipeline getPipeline()
    {
        return this.pipeline;
    }


    public void setPipeline(AbstractPipeline pipeline)
    {
        this.pipeline = pipeline;
    }
}