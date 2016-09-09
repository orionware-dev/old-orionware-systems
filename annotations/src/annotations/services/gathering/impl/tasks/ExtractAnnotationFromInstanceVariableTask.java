package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class ExtractAnnotationFromInstanceVariableTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Field field, Class annotationClassToExtract)
    {
        return field.getAnnotation(annotationClassToExtract);
    }
}