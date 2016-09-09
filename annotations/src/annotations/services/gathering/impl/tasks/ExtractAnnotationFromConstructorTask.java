package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class ExtractAnnotationFromConstructorTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Constructor<?> constructor, Class annotationClassToExtract)
    {
        return constructor.getAnnotation(annotationClassToExtract);
    }
}