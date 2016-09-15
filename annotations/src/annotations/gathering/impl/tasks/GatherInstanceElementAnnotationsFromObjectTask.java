package annotations.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;

public class GatherInstanceElementAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public static List<OrionAnnotation> run(AccessibleObject objectElement)
    {
        if(objectElement != null)
        {
            List<OrionAnnotation> annotationsList = new ArrayList<OrionAnnotation>();
            
            for(Annotation annotation : objectElement.getAnnotations())
            {
                OrionAnnotation orionAnnotation = new OrionAnnotation(annotation.annotationType().getName(), null, null, null);
                annotationsList.add(orionAnnotation);
            }
            
            return annotationsList;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}