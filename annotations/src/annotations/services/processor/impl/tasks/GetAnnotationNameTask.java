package annotations.services.processor.impl.tasks;

import java.lang.annotation.Annotation;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class GetAnnotationNameTask extends AnnotationServiceObject implements AnnotationTask
{
    public String run(Annotation annotation)
    {
        if(annotation != null)
        {
            return annotation.annotationType().getName();
        }
        
        return "";
    }
}