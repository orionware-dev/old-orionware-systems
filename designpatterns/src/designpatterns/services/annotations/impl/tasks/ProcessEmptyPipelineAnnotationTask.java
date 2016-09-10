package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;
import reflection.services.accessibleobjects.ReflectionAccessibleObjectsService;
import reflection.services.accessibleobjects.impl.ReflectionAccessibleObjectsServiceImpl;
import reflection.services.accessibleobjects.methods.ReflectionMethodsService;
import reflection.services.accessibleobjects.methods.impl.ReflectionMethodsServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineService pipelineService;
    private ReflectionMethodsService reflectionMethodsService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;
    
    
    public ProcessEmptyPipelineAnnotationTask()
    {
        this.pipelineService = new PipelineServiceImpl();
        this.reflectionMethodsService = new ReflectionMethodsServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(reflectionMethodsService.getMethodsArray(object)).forEach(method -> processMethodForEmptyPipelineInjection(method));
    }
    
    
    private void processMethodForEmptyPipelineInjection(Method method)
    {
        reflectionMethodsService.makeMethodAccessible(method);
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyPipeline.class);
        
        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            reflectionMethodsService.callMethod(method, object, emptyPipeline);
        }
    }
}