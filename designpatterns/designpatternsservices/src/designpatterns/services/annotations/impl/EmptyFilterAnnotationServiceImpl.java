package designpatterns.services.annotations.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.annotations.Injector;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import designpatterns.annotations.EmptyFilter;
import designpatterns.pipeline.AbstractFilter;
import designpatterns.services.DesignPatternsServicesObject;
import designpatterns.services.annotations.EmptyFilterAnnotationService;
import designpatterns.services.pipeline.PipelineFilterService;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsServicesObject implements EmptyFilterAnnotationService
{
    private PipelineFilterService pipelineFilterService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    private Object object;
    
    
    public EmptyFilterAnnotationServiceImpl()
    {
        
    }

    
    @Override
    public void processEmptyFilterAnnotation(Object object)
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