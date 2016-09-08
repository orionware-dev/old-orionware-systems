package designpatterns.facades.annotations.impl;

import core.dependencyinjection.annotations.Injector;
import designpatterns.facades.DesignPatternsFacadesObject;
import designpatterns.facades.annotations.EmptyFilterAnnotationFacade;
import designpatterns.services.annotations.EmptyFilterAnnotationService;
import designpatterns.services.annotations.impl.EmptyFilterAnnotationServiceImpl;

public class EmptyFilterAnnotationFacadeImpl extends DesignPatternsFacadesObject implements EmptyFilterAnnotationFacade
{
    private EmptyFilterAnnotationService emptyFilterAnnotationService;
    
    
    public EmptyFilterAnnotationFacadeImpl()
    {
        this.emptyFilterAnnotationService = new EmptyFilterAnnotationServiceImpl();
    }
    
    
    @Override
    public void processEmptyFilterAnnotation(Object object)
    {
        emptyFilterAnnotationService.processEmptyFilterAnnotation(object);
    }
}