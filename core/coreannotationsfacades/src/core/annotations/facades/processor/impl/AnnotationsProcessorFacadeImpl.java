package core.annotations.facades.processor.impl;

import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.processor.AnnotationsProcessorFacade;
import core.annotations.services.processor.impl.AnnotationsProcessorServiceImpl;

public class AnnotationsProcessorFacadeImpl extends AnnotationFacadeObject implements AnnotationsProcessorFacade
{
    @Override
    public void processAllAnnotations(Object orionObject)
    {
        new AnnotationsProcessorServiceImpl().processAllAnnotations(orionObject);
    }
}