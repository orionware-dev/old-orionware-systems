package annotations.services.processor;

import java.lang.annotation.Annotation;
import annotations.AnnotationService;
import annotations.OrionAnnotation;

public interface AnnotationsProcessorService extends AnnotationService
{
    public void processAllAnnotations(Object orionObject);


    public boolean applyMethodAnnotation(Object orionObject, OrionAnnotation annotationToProcess);
    
    
    public String getAnnotationName(Annotation annotation);
}