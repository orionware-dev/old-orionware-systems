package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.List;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.impl.PipelineFilterServiceImpl;
import reflection.methods.access.ReflectionMethodAccessService;
import reflection.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private ReflectionMethodAccessService reflectionMethodAccessService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;


    public ProcessEmptyFilterAnnotationTask()
    {
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }


    public void run(Object object)
    {
        this.object = object;
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.stream().forEach(method -> processMethodForEmptyFilterInjection(method));
    }


    private void processMethodForEmptyFilterInjection(Method method)
    {
        reflectionMethodAccessService.makeMethodAccessible(method);
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyFilter.class);

        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = new PipelineFilterServiceImpl().createEmptyFilter();
            reflectionMethodAccessService.callMethod(method, object, emptyFilter);
        }
    }
}