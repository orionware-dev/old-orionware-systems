package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.services.OrionTask;

public class ExtractAnnotationFromMethodTask implements OrionTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}