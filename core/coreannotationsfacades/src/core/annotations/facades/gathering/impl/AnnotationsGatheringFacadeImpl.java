package core.annotations.facades.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;

public class AnnotationsGatheringFacadeImpl extends AnnotationFacadeObject implements AnnotationsGatheringFacade
{
    private AnnotationsGatheringService annotationsGatheringService;
    
    
    public AnnotationsGatheringFacadeImpl()
    {
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return annotationsGatheringService.gatherAllAnnotationsFromObject(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return annotationsGatheringService.extractAnnotationFromMethod(method, annotationClassToExtract);
    }
}