package designpatterns.pipeline.pipe;

import designpatterns.pipeline.AbstractPipeline;

public class Pipeline extends AbstractPipeline
{
    public Pipeline(boolean feedForwardTheResult)
    {
        super(feedForwardTheResult);
    }
}