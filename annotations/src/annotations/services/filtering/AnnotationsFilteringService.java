package annotations.services.filtering;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import annotations.AnnotationService;
import annotations.OrionAnnotation;

public interface AnnotationsFilteringService extends AnnotationService
{
    public Stream<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<Annotation> allObjectAnnotations);
    
    
    public boolean run(Collection<Annotation> allObjectAnnotations, OrionAnnotation registeredAnnotation);
}