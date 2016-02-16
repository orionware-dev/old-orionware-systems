package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.OrionSimpleObject;
import core.annotations.AnnotationTask;

public class ExtractAnnotationFromMethodTask extends OrionSimpleObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}