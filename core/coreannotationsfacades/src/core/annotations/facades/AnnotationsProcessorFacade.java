package core.annotations.facades;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.services.OrionFacade;

public interface AnnotationsProcessorFacade extends OrionFacade
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public void processAllAnnotations(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}