package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.PipelineFilterServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.access.ReflectionMethodAccessService;
import reflection.services.accessibleobjects.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineFilterService pipelineFilterService;
    private ReflectionMethodAccessService reflectionMethodAccessService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;
    
    
    public ProcessEmptyFilterAnnotationTask()
    {
        this.pipelineFilterService = new PipelineFilterServiceImpl();
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(new ReflectionMethodsServiceImpl().getMethodsArray(object)).forEach(method -> processMethodForEmptyFilterInjection(method));
    }
    
    
    private void processMethodForEmptyFilterInjection(Method method)
    {
        reflectionMethodAccessService.makeMethodAccessible(method);
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyFilter.class);
        
        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = pipelineFilterService.createEmptyFilter();
            reflectionMethodAccessService.callMethod(method, object, emptyFilter);
        }
    }
}