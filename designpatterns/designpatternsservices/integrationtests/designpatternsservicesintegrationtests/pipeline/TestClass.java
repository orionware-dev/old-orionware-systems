package designpatternsservicesintegrationtests.pipeline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import core.runnables.consumers.Consumer1;
import core.runnables.functions.Function1x1;
import designpatterns.DesignPatternsObject;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineFilterServiceImpl;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;

public class TestClass extends DesignPatternsObject
{
    public void printHello(String message)
    {
        System.out.println("hello " + message);
    }
}