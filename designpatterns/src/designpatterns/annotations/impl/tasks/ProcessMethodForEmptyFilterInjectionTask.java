package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;

public class ProcessMethodForEmptyFilterInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object, Method method)
    {
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)new AnnotationsGatheringServiceImpl()
                        .extractAnnotationFromMethod(method, EmptyFilter.class);

        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = new PipelineFilterServiceImpl().createEmptyFilter();
            new DependencyInjectorServiceImpl().injectObjectToMethod(object, emptyFilter, method);
        }
    }
}