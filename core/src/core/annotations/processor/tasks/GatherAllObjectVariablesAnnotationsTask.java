package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectVariablesAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectVariablesAnnotationsList;
    
    
    public List<Annotation> run(OrionObject object)
    {
        allObjectVariablesAnnotationsList = new ArrayList<Annotation>();
        Arrays.stream(object.getClass().getDeclaredFields())
            .forEach((variable) -> gatherAllVariablesAnnotations(variable));
        return allObjectVariablesAnnotationsList;
    }
    
    
    private void gatherAllVariablesAnnotations(Field variable)
    {
        allObjectVariablesAnnotationsList.addAll(Arrays.asList(variable.getAnnotations()));
    }
}