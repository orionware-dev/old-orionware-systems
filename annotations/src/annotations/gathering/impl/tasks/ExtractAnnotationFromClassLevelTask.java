package annotations.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;

public class ExtractAnnotationFromClassLevelTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Annotation run(Class<?> aClass, Class annotationClassToExtract)
    {
        return aClass.getAnnotation(annotationClassToExtract);
    }
}