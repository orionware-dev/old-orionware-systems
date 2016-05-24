package core.annotations.facades.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.AnnotationsProcessorFacade;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;

public class AnnotationsProcessorFacadeImpl extends AnnotationFacadeObject implements AnnotationsProcessorFacade
{
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public AnnotationsProcessorFacadeImpl()
    {
        annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return annotationsProcessorService.gatherAllAnnotationsFromObject(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        annotationsProcessorService.processAllAnnotations(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return annotationsProcessorService.extractAnnotationFromMethod(method, annotationClassToExtract);
    }
}