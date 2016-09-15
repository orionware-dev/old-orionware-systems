package designpatterns.pipeline.impl;

import dependencyinjection.annotation.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineService;
import designpatterns.pipeline.impl.tasks.AddFilterToPipelineTask;
import designpatterns.pipeline.impl.tasks.CreateEmptyPipelineTask;
import designpatterns.pipeline.impl.tasks.ExecuteFiltersTask;
import designpatterns.pipeline.pipe.Pipeline;

public class PipelineServiceImpl extends DesignPatternsObject implements PipelineService
{
    @Injector
    private CreateEmptyPipelineTask createEmptyPipelineTask;
    @Injector
    private ExecuteFiltersTask executeFiltersTask;
    @Injector
    private AddFilterToPipelineTask addFilterToPipelineTask;
    
    
    @Override
    public AbstractPipeline createEmptyPipeline(boolean feedForwardTheResult)
    {
        return createEmptyPipelineTask.run(feedForwardTheResult);
    }


    @Override
    public void addFilterToPipeline(AbstractPipeline pipeline, AbstractFilter filter)
    {
        addFilterToPipelineTask.run(pipeline, filter);
    }


    @Override
    public Object executeFilters(AbstractPipeline pipeline)
    {
        return executeFiltersTask.run(pipeline);
    }
}