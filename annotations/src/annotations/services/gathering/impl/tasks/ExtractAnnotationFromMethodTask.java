package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class ExtractAnnotationFromMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}