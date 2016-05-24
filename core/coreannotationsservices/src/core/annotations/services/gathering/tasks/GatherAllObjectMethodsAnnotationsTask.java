package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;

public class GatherAllObjectMethodsAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    private List<Annotation> allObjectMethodsAnnotationsList;
    
    
    public GatherAllObjectMethodsAnnotationsTask()
    {
        this.allObjectMethodsAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
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