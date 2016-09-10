package annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import annotations.AnnotationService;
import annotations.OrionAnnotation;

public interface AnnotationsGatheringService extends AnnotationService
{
    public List<OrionAnnotation> gatherAllAnnotationsFromObject(Object object);
    
    
    public Annotation extractAnnotationFromClassLevel(Class<?> aClass, Class<?> annotationClassToExtract);
    
    
    public Annotation extractAnnotationFromInstanceVariable(Field instanceVariable, Class<?> annotationClassToExtract);
    
    
    public Annotation extractAnnotationFromConstructor(Constructor<?> constructor, Class<?> annotationClassToExtract);


    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
    
    
    public List<OrionAnnotation> gatherClassLevelAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherInstanceVariablesAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherConstructorsAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherMethodsAnnotationsFromObject(Object object);
    
    
    public List<OrionAnnotation> gatherObjectElementAnnotationsFromObject(AccessibleObject objectElement);
}