package core.annotations.facades.processor;

import core.services.OrionFacade;

public interface AnnotationsProcessorFacade extends OrionFacade
{
    public void processAllAnnotations(Object OrionObject);
}