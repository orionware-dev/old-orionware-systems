package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
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
        Method[] methods = object.getClass().getDeclaredMethods();
        Stream<Method> methodsStream = Arrays.stream(methods);
        methodsStream.forEach((method) -> getMethodAnnotationsAndAppendThemToList(method));
        return allObjectMethodsAnnotationsList;
    }
    
    
    private void getMethodAnnotationsAndAppendThemToList(Method method)
    {
        Annotation[] annotations = method.getAnnotations();
        allObjectMethodsAnnotationsList.addAll(Arrays.asList(annotations));
    }
}