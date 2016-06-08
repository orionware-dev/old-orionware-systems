package core.annotations.services.filtering.impl;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.tasks.FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask;
import core.annotations.services.filtering.impl.tasks.IsAnnotationRegisteredTask;

public class AnnotationsFilteringServiceImpl extends AnnotationServiceObject implements AnnotationsFilteringService
{
    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(Collection<Annotation> allObjectAnnotationsList)
    {
        return new FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask().run(allObjectAnnotationsList);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return IsAnnotationRegisteredTask.run(annotation);
    }
}