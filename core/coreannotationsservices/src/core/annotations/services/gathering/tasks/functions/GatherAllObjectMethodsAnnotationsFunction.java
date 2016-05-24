package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.functions.OrionAbstractFunction;

public class GatherAllObjectMethodsAnnotationsFunction extends OrionAbstractFunction
{
    private List<Annotation> allObjectMethodsAnnotationsList;
    
    
    public GatherAllObjectMethodsAnnotationsFunction()
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