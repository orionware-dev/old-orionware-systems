package core.annotations.services.filtering.impl;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.tasks.DoesObjectHaveRegisteredAnnotationTask;
import core.annotations.services.filtering.impl.tasks.FilterRegisteredAnnotationsFromObjectAnnotationsTask;

public class AnnotationsFilteringServiceImpl extends AnnotationServiceObject implements AnnotationsFilteringService
{
    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<Annotation> allObjectAnnotationsList)
    {
        return new FilterRegisteredAnnotationsFromObjectAnnotationsTask().run(allObjectAnnotationsList);
    }

    
    @Override
    public boolean run(Collection<Annotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        return new DoesObjectHaveRegisteredAnnotationTask().run(allObjectAnnotations, registeredAnnotation);
    }
}