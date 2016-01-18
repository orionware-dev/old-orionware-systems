package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectAnnotationsList;
    
    
    public List<Annotation> run(OrionObject object)
    {
        allObjectAnnotationsList = new ArrayList<Annotation>();
        gatherAllClassAnnotations(object);
        Arrays.stream(object.getClass().getDeclaredMethods())
            .forEach((method) -> gatherAllMethodsAnnotations(method));
        Arrays.stream(object.getClass().getDeclaredFields())
            .forEach((variable) -> gatherAllVariablesAnnotations(variable));
        
        return allObjectAnnotationsList;
    }
    
    
    private void gatherAllClassAnnotations(OrionObject object)
    {
        allObjectAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
    }
    
    
    private void gatherAllMethodsAnnotations(Method method)
    {
        allObjectAnnotationsList.addAll(Arrays.asList(method.getAnnotations()));
    }
    
    
    private void gatherAllVariablesAnnotations(Field variable)
    {
        allObjectAnnotationsList.addAll(Arrays.asList(variable.getAnnotations()));
    }
}