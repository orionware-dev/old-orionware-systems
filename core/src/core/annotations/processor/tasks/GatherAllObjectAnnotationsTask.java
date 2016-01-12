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
    private OrionObject object;
    
    
    public GatherAllObjectAnnotationsTask(OrionObject object)
    {
        this.object = object;
    }
    

    @Override
    public Object execute(Object... methodParameters)
    {
        List<Annotation> allObjectAnnotationsList = new ArrayList<Annotation>();
        allObjectAnnotationsList.addAll(Arrays.asList(object.getClass().getAnnotations()));
        Arrays.stream(object.getClass().getDeclaredMethods())
            .forEach((method) -> gatherAllMethodsAnnotations(method, allObjectAnnotationsList));
        Arrays.stream(object.getClass().getDeclaredFields())
            .forEach((variable) -> gatherAllVariablesAnnotations(variable, allObjectAnnotationsList));
        
        return allObjectAnnotationsList;
    }
    
    
    private void gatherAllMethodsAnnotations(Method method, List<Annotation> allObjectAnnotationsList)
    {
        allObjectAnnotationsList.addAll(Arrays.asList(method.getAnnotations()));
    }
    
    
    private void gatherAllVariablesAnnotations(Field variable, List<Annotation> allObjectAnnotationsList)
    {
        allObjectAnnotationsList.addAll(Arrays.asList(variable.getAnnotations()));
    }

    
    @Override
    public Object[] executeAndReturnArray(Object... methodParameters)
    {
        return null;
    }
}