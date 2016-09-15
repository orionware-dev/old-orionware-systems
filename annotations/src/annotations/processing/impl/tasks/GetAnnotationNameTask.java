package annotations.processing.impl.tasks;

import java.lang.annotation.Annotation;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;

public class GetAnnotationNameTask extends AnnotationServiceObject implements AnnotationTask
{
    public static String run(Annotation annotation)
    {
        if(annotation != null)
        {
            return annotation.annotationType().getName();
        }
        
        return "";
    }
}