package core.annotations.facades.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.services.OrionFacade;

public interface AnnotationsGatheringFacade extends OrionFacade
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}