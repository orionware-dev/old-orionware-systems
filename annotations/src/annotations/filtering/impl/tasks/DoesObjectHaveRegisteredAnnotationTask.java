package annotations.filtering.impl.tasks;

import java.util.Collection;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class DoesObjectHaveRegisteredAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public static boolean run(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation)
    {
        for(OrionAnnotation orionAnnotation : allObjectAnnotations)
        {
            if(orionAnnotation.getAnnotationClass().equals(registeredAnnotation.getAnnotationClass()))
            {
                return true;
            }
        }
        
        return false;
    }
}