package annotations.processing;

import annotations.AnnotationService;

public interface AnnotationsProcessorService extends AnnotationService
{
    public void processAllAnnotations(Object object);
}