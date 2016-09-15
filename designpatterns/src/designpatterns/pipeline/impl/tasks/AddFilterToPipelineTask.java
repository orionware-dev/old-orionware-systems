package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;

public class AddFilterToPipelineTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(AbstractPipeline pipeline, AbstractFilter filter)
    {
        pipeline.addFilter(filter);
    }
}