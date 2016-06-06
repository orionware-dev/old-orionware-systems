package core.annotations.facades.filtering.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.filtering.AnnotationsFilteringFacade;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;

public class AnnotationsFilteringFacadeImpl extends AnnotationFacadeObject implements AnnotationsFilteringFacade
{
    private AnnotationsFilteringService annotationsFilteringService;
    
    
    public AnnotationsFilteringFacadeImpl()
    {
        this.annotationsFilteringService = new AnnotationsFilteringServiceImpl();
    }


    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList)
    {
        return annotationsFilteringService.filterRegisteredAnnotationsStreamFromObjectAnnotations(allObjectAnnotationsList);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return annotationsFilteringService.isAnnotationRegistered(annotation);
    }
}