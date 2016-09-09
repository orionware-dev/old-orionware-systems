package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;

public class GatherObjectElementAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<OrionAnnotation> run(AccessibleObject objectElement)
    {
        if(objectElement != null)
        {
            Annotation[] annotations = objectElement.getAnnotations();
            List<OrionAnnotation> annotationsList = new ArrayList<OrionAnnotation>();
            
            for(Annotation annotation : annotations)
            {
                OrionAnnotation orionAnnotation = new OrionAnnotation(annotation.annotationType().getName(), null, null, null);
                annotationsList.add(orionAnnotation);
            }
            
            return annotationsList;
        }
        
        return new ArrayList<OrionAnnotation>();
    }
}