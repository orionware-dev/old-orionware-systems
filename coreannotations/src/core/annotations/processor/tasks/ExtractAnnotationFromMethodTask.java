package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;

public class ExtractAnnotationFromMethodTask implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}