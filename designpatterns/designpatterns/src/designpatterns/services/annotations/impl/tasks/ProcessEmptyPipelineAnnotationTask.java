package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyPipeline;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.services.pipeline.PipelineService;
import designpatterns.services.pipeline.impl.PipelineServiceImpl;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineService pipelineService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    private Object object;
    
    
    public ProcessEmptyPipelineAnnotationTask()
    {
        this.pipelineService = new PipelineServiceImpl();
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        this.annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object)).forEach(method -> processMethodForEmptyPipelineInjection(method));
    }
    
    
    private void processMethodForEmptyPipelineInjection(Method method)
    {
        reflectionLoaderFacade.makeMethodAccessible(method);
        EmptyPipeline emptyPipelineAnnotation = (EmptyPipeline)annotationsGatheringFacade.extractAnnotationFromMethod(method, EmptyPipeline.class);
        
        if(emptyPipelineAnnotation != null)
        {
            boolean feedForwardTheResult = emptyPipelineAnnotation.feedForwardTheResult();
            AbstractPipeline emptyPipeline = pipelineService.createEmptyPipeline(feedForwardTheResult);
            reflectionLoaderFacade.callMethod(method, object, emptyPipeline);
        }
    }
}