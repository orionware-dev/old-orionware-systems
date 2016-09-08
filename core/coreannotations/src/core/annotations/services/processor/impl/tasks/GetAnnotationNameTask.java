package core.annotations.services.processor.impl.tasks;

import java.lang.annotation.Annotation;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

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