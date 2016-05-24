package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllObjectVariablesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectVariablesAnnotationsList;
    
    
    public GatherAllObjectVariablesAnnotationsTask()
    {
        this.allObjectVariablesAnnotationsList = new ArrayList<Annotation>();
    }
    
    
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