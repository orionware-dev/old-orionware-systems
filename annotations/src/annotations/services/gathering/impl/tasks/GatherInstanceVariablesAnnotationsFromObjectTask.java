package annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;

public class GatherInstanceVariablesAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        List<Annotation> annotations = new ArrayList<Annotation>();
        
        if(object != null)
        {
            GatherObjectElementAnnotationsFromObjectTask gatherObjectElementAnnotationsFromObjectTask = new GatherObjectElementAnnotationsFromObjectTask();
            Field[] variables = object.getClass().getDeclaredFields();
            Arrays.stream(variables).forEach(variable -> annotations.addAll(gatherObjectElementAnnotationsFromObjectTask.run(variable)));
        }
        
        return annotations;
    }
}