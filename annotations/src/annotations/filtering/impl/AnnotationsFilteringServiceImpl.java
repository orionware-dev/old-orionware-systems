package annotations.filtering.impl;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.filtering.AnnotationsFilteringService;
import annotations.filtering.impl.tasks.AddAnnotationTypeForObjectTask;
import annotations.filtering.impl.tasks.DoesObjectHaveRegisteredAnnotationTask;
import annotations.filtering.impl.tasks.FilterRegisteredAnnotationsFromObjectAnnotationsTask;

public class AnnotationsFilteringServiceImpl extends AnnotationServiceObject implements AnnotationsFilteringService
{
    @Override
    public List<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<OrionAnnotation> allObjectAnnotationsList)
    {
        return new FilterRegisteredAnnotationsFromObjectAnnotationsTask().run(allObjectAnnotationsList);
    }


    @Override
    public boolean run(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        return new DoesObjectHaveRegisteredAnnotationTask().run(allObjectAnnotations, registeredAnnotation);
    }


    @Override
    public void addAnnotationTypeForObject(OrionAnnotation annotation, AnnotationType annotationType)
    {
        new AddAnnotationTypeForObjectTask().run(annotation, annotationType);
    }
}