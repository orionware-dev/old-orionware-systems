package designpatterns.pipeline.impl.tasks;

import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.pipe.Pipeline;

public class CreateEmptyPipelineTask extends DesignPatternsObject implements DesignPatternsTask
{
    public AbstractPipeline run(boolean feedForwardTheResult)
    {
        return new Pipeline(feedForwardTheResult);
    }
}