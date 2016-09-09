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
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineFilterService pipelineFilterService;
    private ReflectionLoaderService reflectionLoaderService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;
    
    
    public ProcessEmptyFilterAnnotationTask()
    {
        this.pipelineFilterService = new PipelineFilterServiceImpl();
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(reflectionLoaderService.getMethodsArray(object)).forEach(method -> processMethodForEmptyFilterInjection(method));
    }
    
    
    private void processMethodForEmptyFilterInjection(Method method)
    {
        reflectionLoaderService.makeMethodAccessible(method);
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyFilter.class);
        
        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = pipelineFilterService.createEmptyFilter();
            reflectionLoaderService.callMethod(method, object, emptyFilter);
        }
    }
}