package annotations.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;

public class ExtractAnnotationFromMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}