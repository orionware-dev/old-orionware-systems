package core.annotations.services.filtering;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;

public interface AnnotationsFilteringService extends AnnotationService
{
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(Collection<Annotation> allObjectAnnotationsList);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
}