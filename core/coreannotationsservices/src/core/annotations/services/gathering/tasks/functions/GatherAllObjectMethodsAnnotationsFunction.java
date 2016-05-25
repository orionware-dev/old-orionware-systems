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
    private Object object;
    
    
    public GatherAllObjectMethodsAnnotationsFunction()
    {
        this.allObjectMethodsAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        this.object = object;
        gatherMethodsAnnotationsAndPutThemInAList();
        return allObjectMethodsAnnotationsList;
    }
    
    
    private void gatherMethodsAnnotationsAndPutThemInAList()
    {
        getStreamForMethods().forEach((method) -> getMethodAnnotationsAndAppendThemToList(method));
    }
    
    
    private Method[] getMethods()
    {
        return object.getClass().getDeclaredMethods();
    }
    
    
    private Stream<Method> getStreamForMethods()
    {
        return Arrays.stream(getMethods());
    }
    
    
    private Annotation[] getMethodAnnotations(Method method)
    {
        return method.getAnnotations();
    }
    
    
    private void appendMethodAnnotationsToList(Annotation[] annotations)
    {
        allObjectMethodsAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void getMethodAnnotationsAndAppendThemToList(Method method)
    {
        appendMethodAnnotationsToList(getMethodAnnotations(method));
    }
}