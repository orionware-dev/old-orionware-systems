package designpatterns.pipeline.impl;

import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineLifecycleService;
import designpatterns.pipeline.impl.tasks.ExecutePipelineFiltersTask;

public class PipelineLifecycleServiceImpl extends DesignPatternsObject implements PipelineLifecycleService
{
    private AbstractPipeline pipeline;


    @Override
    public void registerPipeline(AbstractPipeline pipeline)
    {
        setPipeline(pipeline);
    }


    @Override
    public Object executePipelineFilters()
    {
        return new ExecutePipelineFiltersTask().run(getPipeline());
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