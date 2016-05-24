package core.annotations.services.processor;

import core.annotations.AnnotationService;

public interface AnnotationsProcessorService extends AnnotationService
{
    public void processAllAnnotations(Object OrionObject);
}