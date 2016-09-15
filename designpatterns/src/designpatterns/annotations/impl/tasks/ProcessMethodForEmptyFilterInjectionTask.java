package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.AnnotationsGatheringService;
import dependencyinjection.annotation.InjectorImpl;
import dependencyinjection.processing.DependencyInjectorService;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.PipelineFilterService;

public class ProcessMethodForEmptyFilterInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    @InjectorImpl
    private AnnotationsGatheringService annotationsGatheringService;
    @InjectorImpl
    private PipelineFilterService pipelineFilterService;
    @InjectorImpl
    private DependencyInjectorService dependencyInjectorService;
    
    
    public void run(Object object, Method method)
    {
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)annotationsGatheringService
                        .extractAnnotationFromMethod(method, EmptyFilter.class);

        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = pipelineFilterService.createEmptyFilter();
            dependencyInjectorService.injectObjectToMethod(object, emptyFilter, method);
        }
    }
}