package annotations.extraction;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import annotations.AnnotationService;

public interface AnnotationsExtractionService extends AnnotationService
{
    public Annotation extractAnnotationFromClassLevel(Class<?> aClass, Class<?> annotationClassToExtract);
    
    
    public Annotation extractAnnotationFromInstanceVariable(Field instanceVariable, Class<?> annotationClassToExtract);
    
    
    public Annotation extractAnnotationFromConstructor(Constructor<?> constructor, Class<?> annotationClassToExtract);


    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
    
    
    public String getAnnotationName(Annotation annotation);
}