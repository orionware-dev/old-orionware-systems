package core.annotations.services.gathering.impl.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherConstructorsAnnotationsFromObjectTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<Annotation> run(Object object)
    {
        List<Annotation> annotations = new ArrayList<Annotation>();
        
        if(object != null)
        {
            GatherObjectElementAnnotationsFromObjectTask gatherObjectElementAnnotationsFromObjectTask = new GatherObjectElementAnnotationsFromObjectTask();
            Constructor<?>[] constructors = object.getClass().getDeclaredConstructors();
            Arrays.stream(constructors).forEach(constructor -> annotations.addAll(gatherObjectElementAnnotationsFromObjectTask.run(constructor)));
        }
        
        return annotations;
    }
}