package designpatterns.facades.annotations.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.annotations.EmptyFilterAnnotationFacade;
import designpatterns.facades.annotations.EmptyPipelineAnnotationFacade;
import designpatterns.services.annotations.EmptyFilterAnnotationService;
import designpatterns.services.annotations.EmptyPipelineAnnotationService;

public class EmptyPipelineAnnotationFacadeImpl extends DesignPatternsFacadesObject implements EmptyPipelineAnnotationFacade
{
    private EmptyPipelineAnnotationService emptyPipelineAnnotationService;
    
    
    public EmptyPipelineAnnotationFacadeImpl()
    {
        
    }
    
    
    @Override
    public void processEmptyPipelineAnnotation(Object object)
    {
        emptyPipelineAnnotationService.processEmptyPipelineAnnotation(object);
    }
    
    
    @Injector(ID = "designpatterns.services.annotations.impl.EmptyPipelineAnnotationServiceImpl")
    private void setEmptyFilterAnnotationService(EmptyPipelineAnnotationService emptyPipelineAnnotationService)
    {
        this.emptyPipelineAnnotationService = emptyPipelineAnnotationService;
    }
}