package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectConstructorsAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectConstructorsAnnotationsList;
    
    
    public List<Annotation> run(OrionObject object)
    {
        allObjectConstructorsAnnotationsList = new ArrayList<Annotation>();
        Arrays.stream(object.getClass().getDeclaredConstructors())
            .forEach((constructor) -> gatherAllConstructorsAnnotations(constructor));
        return allObjectConstructorsAnnotationsList;
    }
    
    
    private void gatherAllConstructorsAnnotations(Constructor<?> constructor)
    {
        allObjectConstructorsAnnotationsList.addAll(Arrays.asList(constructor.getAnnotations()));
    }
}