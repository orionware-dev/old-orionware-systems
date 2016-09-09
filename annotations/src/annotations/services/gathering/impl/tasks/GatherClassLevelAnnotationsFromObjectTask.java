package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class GatherClassLevelAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        if(object != null)
        {
            return Arrays.asList(object.getClass().getAnnotations());
        }
        
        return new ArrayList<Annotation>();
    }
}