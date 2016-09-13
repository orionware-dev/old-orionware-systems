package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.List;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.impl.PipelineServiceImpl;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private ReflectionMethodAccessService reflectionMethodAccessService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;


    public ProcessEmptyPipelineAnnotationTask()
    {
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }


    public void run(Object object)
    {
        this.object = object;
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.stream().forEach(method -> processMethodForEmptyPipelineInjection(method));
    }


    private void processMethodForEmptyPipelineInjection(Method method)
    {
        reflectionMethodAccessService.makeMethodAccessible(method);
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyPipeline.class);

        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = new PipelineServiceImpl().createEmptyPipeline(feedForwardTheResult);
            reflectionMethodAccessService.callMethod(method, object, emptyPipeline);
        }
    }
}