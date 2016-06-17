package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyFilter;
import designpatterns.annotations.EmptyPipeline;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.AbstractPipeline;
import designpatterns.pipeline.filter.Filter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.PipelineService;

public class ProcessEmptyPipelineAnnotationTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    private PipelineService pipelineService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    private Object object;
    
    
    public ProcessEmptyPipelineAnnotationTask()
    {
        
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
    
    
    @Injector(ID = "designpatterns.services.pipeline.impl.PipelineServiceImpl")
    private void setPipelineService(PipelineService pipelineService)
    {
        this.pipelineService = pipelineService;
    }
    
    
    @Injector(ID = "core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl")
    private void setReflectionLoaderFacade(ReflectionLoaderFacade reflectionLoaderFacade)
    {
        this.reflectionLoaderFacade = reflectionLoaderFacade;
    }
    
    
    @Injector(ID = "core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl")
    private void setAnnotationsGatheringFacade(AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        this.annotationsGatheringFacade = annotationsGatheringFacade;
    }
}