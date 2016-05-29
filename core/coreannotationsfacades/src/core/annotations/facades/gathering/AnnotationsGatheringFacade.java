package core.annotations.facades.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.AnnotationFacade;

public interface AnnotationsGatheringFacade extends AnnotationFacade
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}