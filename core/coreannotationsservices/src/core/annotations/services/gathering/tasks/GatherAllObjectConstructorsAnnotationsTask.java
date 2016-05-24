package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllObjectConstructorsAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectConstructorsAnnotationsList;
    
    
    public GatherAllObjectConstructorsAnnotationsTask()
    {
        this.allObjectConstructorsAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        Arrays.stream(object.getClass().getDeclaredConstructors())
            .forEach((constructor) -> gatherAllConstructorsAnnotations(constructor));
        return allObjectConstructorsAnnotationsList;
    }
    
    
    private void gatherAllConstructorsAnnotations(Constructor<?> constructor)
    {
        allObjectConstructorsAnnotationsList.addAll(Arrays.asList(constructor.getAnnotations()));
    }
}