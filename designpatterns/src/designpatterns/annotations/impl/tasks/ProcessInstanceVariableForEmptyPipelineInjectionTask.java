package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import annotations.extraction.AnnotationsExtractionService;
import dependencyinjection.annotation.InjectorImpl;
import dependencyinjection.processing.DependencyInjectorService;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.PipelineService;

public class ProcessInstanceVariableForEmptyPipelineInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private AnnotationsExtractionService annotationsExtractionService;
    @InjectorImpl
    private PipelineService pipelineService;
    @InjectorImpl
    private DependencyInjectorService dependencyInjectorService;
    
    
    public void run(Object object, Field instanceVariable)
    {
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsExtractionService
                        .extractAnnotationFromInstanceVariable(instanceVariable, EmptyPipeline.class);

        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            dependencyInjectorService.injectObjectToInstanceVariable(object, emptyPipeline, instanceVariable);
        }
    }
}