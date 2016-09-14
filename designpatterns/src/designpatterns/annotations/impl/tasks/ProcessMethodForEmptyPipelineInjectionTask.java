package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.PipelineServiceImpl;

public class ProcessMethodForEmptyPipelineInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object, Method method)
    {
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)new AnnotationsGatheringServiceImpl()
                        .extractAnnotationFromMethod(method, EmptyPipeline.class);

        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = new PipelineServiceImpl().createEmptyPipeline(feedForwardTheResult);
            new DependencyInjectorServiceImpl().injectObjectToMethod(object, emptyPipeline, method);
        }
    }
}