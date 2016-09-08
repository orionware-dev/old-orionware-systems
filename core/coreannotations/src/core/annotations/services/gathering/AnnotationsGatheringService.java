package core.annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.AnnotationService;

public interface AnnotationsGatheringService extends AnnotationService
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object orionObject);


    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
    
    
    public List<Annotation> gatherClassLevelAnnotationsFromObject(Object orionObject);
    
    
    public List<Annotation> gatherInstanceVariablesAnnotationsFromObject(Object orionObject);
    
    
    public List<Annotation> gatherConstructorsAnnotationsFromObject(Object orionObject);
    
    
    public List<Annotation> gatherMethodsAnnotationsFromObject(Object orionObject);
    
    
    public List<Annotation> gatherObjectElementAnnotationsFromObject(AccessibleObject objectElement);
}