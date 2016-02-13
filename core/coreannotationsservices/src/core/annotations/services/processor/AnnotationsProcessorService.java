package core.annotations.services.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.AnnotationService;

public interface AnnotationsProcessorService extends AnnotationService
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public void processAllAnnotations(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}