package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.OrionObject;
import core.services.OrionService;

public interface AnnotationsProcessorService extends OrionService
{
    public void processAllAnnotations(OrionObject OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}