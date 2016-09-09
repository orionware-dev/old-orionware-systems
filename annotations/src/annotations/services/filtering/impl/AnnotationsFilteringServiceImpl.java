package annotations.services.filtering.impl;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.filtering.AnnotationsFilteringService;
import annotations.services.filtering.impl.tasks.DoesObjectHaveRegisteredAnnotationTask;
import annotations.services.filtering.impl.tasks.FilterRegisteredAnnotationsFromObjectAnnotationsTask;

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
        annotation.addAnnotationType(annotationType);
    }
}