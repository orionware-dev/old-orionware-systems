package annotations.services.filtering;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import annotations.AnnotationService;
import annotations.AnnotationType;
import annotations.OrionAnnotation;

public interface AnnotationsFilteringService extends AnnotationService
{
    public List<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<OrionAnnotation> allObjectAnnotations);
    
    
    public boolean run(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation);
    
    
    public void addAnnotationTypeForObject(OrionAnnotation annotation, AnnotationType annotationType);
}