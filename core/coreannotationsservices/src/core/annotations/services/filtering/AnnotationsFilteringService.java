package core.annotations.services.filtering;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;

public interface AnnotationsFilteringService extends AnnotationService
{
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
}