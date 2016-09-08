package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.DesignPatternsObject;
import designpatterns.services.pipeline.PipelineFilterService;
import designpatterns.services.pipeline.impl.PipelineFilterServiceImpl;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsObject implements DesignPatternsTask
{
    private PipelineFilterService pipelineFilterService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    private Object object;
    
    
    public ProcessEmptyFilterAnnotationTask()
    {
        this.pipelineFilterService = new PipelineFilterServiceImpl();
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        this.annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
    }
    
    
    public void run(Object object)
    {
        this.object = object;
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object)).forEach(method -> processMethodForEmptyFilterInjection(method));
    }
    
    
    private void processMethodForEmptyFilterInjection(Method method)
    {
        reflectionLoaderFacade.makeMethodAccessible(method);
        EmptyFilter emptyFilterAnnotation = (EmptyFilter)annotationsGatheringFacade.extractAnnotationFromMethod(method, EmptyFilter.class);
        
        if(emptyFilterAnnotation != null)
        {
            AbstractFilter emptyFilter = pipelineFilterService.createEmptyFilter();
            reflectionLoaderFacade.callMethod(method, object, emptyFilter);
        }
    }
}