package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class GatherObjectElementAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(AccessibleObject objectElement)
    {
        if(objectElement != null)
        {
            Annotation[] annotations = objectElement.getAnnotations();
            return Arrays.asList(annotations);
        }
        
        return new ArrayList<Annotation>();
    }
}