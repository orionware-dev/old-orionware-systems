package designpatterns.services.annotations.impl.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import designpatterns.DesignPatternsTask;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.pipeline.filter.Filter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.pipeline.PipelineFilterService;

public class ProcessEmptyFilterAnnotationTask extends DesignPatternsServicesObject implements DesignPatternsTask
{
    private PipelineFilterService pipelineFilterService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    private Object object;
    
    
    public ProcessEmptyFilterAnnotationTask()
    {
        
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
    
    
    @Injector(ID = "designpatterns.services.pipeline.impl.PipelineFilterServiceImpl")
    private void setPipelineFilterService(PipelineFilterService pipelineFilterService)
    {
        this.pipelineFilterService = pipelineFilterService;
    }
    
    
    
    
    
    @Injector(ID = "core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl")
    private void setAnnotationsGatheringFacade(AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        this.annotationsGatheringFacade = annotationsGatheringFacade;
    }
    
    
    @Injector(ID = "core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl")
    private void setReflectionLoaderFacade(ReflectionLoaderFacade reflectionLoaderFacade)
    {
        this.reflectionLoaderFacade = reflectionLoaderFacade;
    }
}