package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.OrionAnnotationService;

public interface AnnotationsProcessorService extends OrionAnnotationService
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public void processAllAnnotations(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}