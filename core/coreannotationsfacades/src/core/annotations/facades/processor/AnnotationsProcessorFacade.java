package core.annotations.facades.processor;

import core.annotations.AnnotationFacade;

public interface AnnotationsProcessorFacade extends AnnotationFacade
{
    public void processAllAnnotations(Object orionObject);
}