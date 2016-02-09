package core.annotations.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.OrionObject;
import core.services.OrionTask;

public class GatherAllObjectMethodsAnnotationsTask implements OrionTask
{
    private List<Annotation> allObjectMethodsAnnotationsList = new ArrayList<Annotation>();
    
    
    public List<Annotation> run(OrionObject object)
    {
        Arrays.stream(object.getClass().getDeclaredMethods())
            .forEach((method) -> gatherAllMethodsAnnotations(method));        
        return allObjectMethodsAnnotationsList;
    }
    
    
    private void gatherAllMethodsAnnotations(Method method)
    {
        allObjectMethodsAnnotationsList.addAll(Arrays.asList(method.getAnnotations()));
    }
}