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
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineService pipelineService;
    private ReflectionLoaderService reflectionLoaderService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;
    
    
    public ProcessEmptyPipelineAnnotationTask()
    {
        this.pipelineService = new PipelineServiceImpl();
        this.reflectionLoaderService = new ReflectionLoaderServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(reflectionLoaderService.getMethodsArray(object)).forEach(method -> processMethodForEmptyPipelineInjection(method));
    }
    
    
    private void processMethodForEmptyPipelineInjection(Method method)
    {
        reflectionLoaderService.makeMethodAccessible(method);
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyPipeline.class);
        
        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            reflectionLoaderService.callMethod(method, object, emptyPipeline);
        }
    }
}