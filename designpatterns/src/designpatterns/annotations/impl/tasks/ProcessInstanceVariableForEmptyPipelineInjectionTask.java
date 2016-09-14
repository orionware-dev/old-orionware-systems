package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.PipelineServiceImpl;

public class ProcessInstanceVariableForEmptyPipelineInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object, Field instanceVariable)
    {
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)new AnnotationsGatheringServiceImpl()
                        .extractAnnotationFromInstanceVariable(instanceVariable, EmptyPipeline.class);

        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = new PipelineServiceImpl().createEmptyPipeline(feedForwardTheResult);
            new DependencyInjectorServiceImpl().injectObjectToInstanceVariable(object, emptyPipeline, instanceVariable);
        }
    }
}