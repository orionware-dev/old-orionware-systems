package annotations.filtering;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationService;
import annotations.AnnotationType;
import annotations.OrionAnnotation;

public interface AnnotationsFilteringService extends AnnotationService
{
    public List<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<OrionAnnotation> allObjectAnnotations);
    
    
    public boolean doesObjectHaveRegisteredAnnotation(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation);
    
    
    public void addAnnotationTypeForObject(OrionAnnotation annotation, AnnotationType annotationType);
}