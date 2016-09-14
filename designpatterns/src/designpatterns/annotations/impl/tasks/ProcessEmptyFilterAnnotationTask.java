package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.List;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private Object object;


    public void run(Object object)
    {
        this.object = object;
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyFilterInjection(method));
    }


    private void processMethodForEmptyFilterInjection(Method method)
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