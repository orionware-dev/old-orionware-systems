package core.annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.AnnotationService;

public interface AnnotationsGatheringService extends AnnotationService
{
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject);


    public Annotation extractAnnotationFromMethod(Method method, Class<?> annotationClassToExtract);
}