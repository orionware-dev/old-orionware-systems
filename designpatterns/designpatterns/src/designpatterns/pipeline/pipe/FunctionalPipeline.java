package designpatterns.pipeline.pipe;

import designpatterns.pipeline.AbstractPipeline;

public class FunctionalPipeline extends AbstractPipeline
{
    public FunctionalPipeline()
    {
        setAProceduralPipeline(false);
    }
}