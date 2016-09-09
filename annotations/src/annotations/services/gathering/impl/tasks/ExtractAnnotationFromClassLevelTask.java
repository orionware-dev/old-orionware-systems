package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class ExtractAnnotationFromClassLevelTask extends AnnotationServiceObject implements AnnotationTask
{
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Annotation run(Class<?> aClass, Class annotationClassToExtract)
    {
        return aClass.getAnnotation(annotationClassToExtract);
    }
}