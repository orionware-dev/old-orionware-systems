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
    public Stream<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(List<Annotation> allObjectAnnotationsList)
    {
        return annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allObjectAnnotationsList);
    }
}