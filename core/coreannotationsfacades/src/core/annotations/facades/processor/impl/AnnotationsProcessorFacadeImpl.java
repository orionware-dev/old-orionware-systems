package core.annotations.facades.processor.impl;

import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.processor.AnnotationsProcessorFacade;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;

public class AnnotationsProcessorFacadeImpl extends AnnotationFacadeObject implements AnnotationsProcessorFacade
{
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public AnnotationsProcessorFacadeImpl()
    {
        this.annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        annotationsProcessorService.processAllAnnotations(OrionObject);
    }
}