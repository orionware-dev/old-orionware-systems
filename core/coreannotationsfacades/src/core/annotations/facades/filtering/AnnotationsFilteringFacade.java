package core.annotations.facades.filtering;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationFacade;
import core.annotations.OrionAnnotation;

public interface AnnotationsFilteringFacade extends AnnotationFacade
{
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
}