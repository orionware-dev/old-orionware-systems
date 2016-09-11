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
import reflection.services.accessibleobjects.methods.access.ReflectionMethodAccessService;
import reflection.services.accessibleobjects.methods.access.impl.ReflectionMethodAccessServiceImpl;
import reflection.services.accessibleobjects.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineService pipelineService;
    private ReflectionMethodAccessService reflectionMethodAccessService;
    private AnnotationsGatheringService annotationsGatheringService;
    private Object object;
    
    
    public ProcessEmptyPipelineAnnotationTask()
    {
        this.pipelineService = new PipelineServiceImpl();
        this.reflectionMethodAccessService = new ReflectionMethodAccessServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethodsArray(object)).forEach(method -> processMethodForEmptyPipelineInjection(method));
    }
    
    
    private void processMethodForEmptyPipelineInjection(Method method)
    {
        reflectionMethodAccessService.makeMethodAccessible(method);
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringService.extractAnnotationFromMethod(method, EmptyPipeline.class);
        
        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            reflectionMethodAccessService.callMethod(method, object, emptyPipeline);
        }
    }
}