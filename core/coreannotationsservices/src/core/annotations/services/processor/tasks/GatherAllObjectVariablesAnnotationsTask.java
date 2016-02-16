package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionSimpleObject;
import core.annotations.AnnotationTask;

public class GatherAllObjectVariablesAnnotationsTask extends OrionSimpleObject implements AnnotationTask
{
    private List<Annotation> allObjectVariablesAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(Object object)
    {
        Arrays.stream(object.getClass().getDeclaredFields())
            .forEach((variable) -> gatherAllVariablesAnnotations(variable));
        return allObjectVariablesAnnotationsList;
    }
    
    
    private void gatherAllVariablesAnnotations(Field variable)
    {
        allObjectVariablesAnnotationsList.addAll(Arrays.asList(variable.getAnnotations()));
    }
}