package designpatterns.services.pipeline.impl;

import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineLifecycleService;

public class PipelineLifecycleServiceImpl extends DesignPatternsServicesObject implements PipelineLifecycleService
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
            int index = 0;

            for(AbstractFilter filter : getPipeline().getFilters())
            {
                if(index == 0)
                {
                    pipelineResult = pipelineFilterService.executeFilter(filter, null);
                }
                else
                {
                    pipelineResult = pipelineFilterService.executeFilter(filter, pipelineResult);
                }
                
                getPipeline().setLastFunctionResult(pipelineResult);
                ++index;
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