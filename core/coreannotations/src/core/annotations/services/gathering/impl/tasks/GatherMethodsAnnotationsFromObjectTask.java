package core.annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherMethodsAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        List<Annotation> annotations = new ArrayList<Annotation>();
        
        if(object != null)
        {
            GatherObjectElementAnnotationsFromObjectTask gatherObjectElementAnnotationsFromObjectTask = new GatherObjectElementAnnotationsFromObjectTask();
            Method[] methods = object.getClass().getDeclaredMethods();
            Arrays.stream(methods).forEach(method -> annotations.addAll(gatherObjectElementAnnotationsFromObjectTask.run(method)));
        }
        
        return annotations;
    }
}