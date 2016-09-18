package annotations.extraction.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;

public class ExtractAnnotationFromInstanceVariableTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Annotation run(Field field, Class annotationClassToExtract)
    {
        return field.getAnnotation(annotationClassToExtract);
    }
}