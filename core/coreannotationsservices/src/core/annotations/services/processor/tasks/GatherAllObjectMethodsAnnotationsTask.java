package core.annotations.services.processor.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import core.OrionSimpleObject;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.registry.RegisteredAnnotations;
import core.configuration.registry.AllProperties;

public class GatherAllObjectMethodsAnnotationsTask extends OrionSimpleObject implements AnnotationTask
{
    private List<Annotation> allObjectMethodsAnnotationsList = new ArrayList<Annotation>();
    
    
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