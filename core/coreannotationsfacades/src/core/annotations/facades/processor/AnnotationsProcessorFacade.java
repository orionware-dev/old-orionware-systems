package core.annotations.facades.processor;

import core.annotations.AnnotationFacade;
import core.services.OrionFacade;

public interface AnnotationsProcessorFacade extends AnnotationFacade
{
    public void processAllAnnotations(Object OrionObject);
}