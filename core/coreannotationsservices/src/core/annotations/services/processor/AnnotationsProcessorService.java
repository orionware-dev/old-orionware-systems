package core.annotations.services.processor;

import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;

public interface AnnotationsProcessorService extends AnnotationService
{
    public void processAllAnnotations(Object OrionObject);
    
    
    public boolean applyMethodAnnotation(Object OrionObject, OrionAnnotation annotationToProcess);
}