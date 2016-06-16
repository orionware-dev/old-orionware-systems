package designpatterns.facades.annotations.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.annotations.EmptyFilterAnnotationFacade;
import designpatterns.services.annotations.EmptyFilterAnnotationService;

public class EmptyFilterAnnotationFacadeImpl extends DesignPatternsFacadesObject implements EmptyFilterAnnotationFacade
{
    private EmptyFilterAnnotationService emptyFilterAnnotationService;
    
    
    public EmptyFilterAnnotationFacadeImpl()
    {
        
    }
    
    
    @Override
    public void processEmptyFilterAnnotation(Object object)
    {
        emptyFilterAnnotationService.processEmptyFilterAnnotation(object);
    }
    
    
    @Injector(ID = "designpatterns.services.annotations.impl.EmptyFilterAnnotationServiceImpl")
    private void setEmptyFilterAnnotationService(EmptyFilterAnnotationService emptyFilterAnnotationService)
    {
        this.emptyFilterAnnotationService = emptyFilterAnnotationService;
    }
}