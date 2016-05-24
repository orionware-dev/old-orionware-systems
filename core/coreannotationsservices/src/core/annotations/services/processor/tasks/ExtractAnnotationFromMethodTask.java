package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class ExtractAnnotationFromMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}