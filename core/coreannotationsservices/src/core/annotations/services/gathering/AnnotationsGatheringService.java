package core.annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;

public interface AnnotationsGatheringService extends AnnotationService
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);
    
    
    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
    
    
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList);
    
    
    public boolean isAnnotationRegisteredTask(OrionAnnotation annotation);
}