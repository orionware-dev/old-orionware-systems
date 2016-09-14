package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;

public class ProcessInstanceVariableForEmptyFilterInjectionTask extends DesignPatternsObject implements DesignPatternsTask
{
    public void run(Object object, Field instanceVariable)
    {
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)new AnnotationsGatheringServiceImpl()
                        .extractAnnotationFromInstanceVariable(instanceVariable, EmptyFilter.class);

        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = new PipelineFilterServiceImpl().createEmptyFilter();
            new DependencyInjectorServiceImpl().injectObjectToInstanceVariable(object, emptyFilter, instanceVariable);
        }
    }
}