package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.AnnotationsGatheringService;
import dependencyinjection.annotation.InjectorImpl;
import dependencyinjection.processing.DependencyInjectorService;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineService;

public class ProcessMethodForEmptyPipelineInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private AnnotationsGatheringService annotationsGatheringService;
    @InjectorImpl
    private PipelineService pipelineService;
    @InjectorImpl
    private DependencyInjectorService dependencyInjectorService;
    
    
    public void run(Object object, Method method)
    {
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringService
                        .extractAnnotationFromMethod(method, EmptyPipeline.class);

        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            dependencyInjectorService.injectObjectToMethod(object, emptyPipeline, method);
        }
    }
}