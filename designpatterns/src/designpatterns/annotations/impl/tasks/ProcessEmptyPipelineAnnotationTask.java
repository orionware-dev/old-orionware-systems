package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.List;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import dependencyinjection.processing.impl.DependencyInjectorServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotation.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.PipelineServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private Object object;


    public void run(Object object)
    {
        this.object = object;
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyPipelineInjection(method));
    }


    private void processMethodForEmptyPipelineInjection(Method method)
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