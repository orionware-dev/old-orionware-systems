package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import core.functions.OrionAbstractFunction;

public class GatherAllObjectConstructorsAnnotationsFunction extends OrionAbstractFunction
{
    private List<Annotation> allObjectConstructorsAnnotationsList;
    private Object object;
    
    
    public GatherAllObjectConstructorsAnnotationsFunction()
    {
        this.allObjectConstructorsAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        this.object = object;
        gatherConstructorsAnnotationsAndPutThemInAList();
        return allObjectConstructorsAnnotationsList;
    }
    
    
    private void gatherConstructorsAnnotationsAndPutThemInAList()
    {
        getStreamForConstructors().forEach((constructor) -> getConstructorAnnotationsAndAppendThemToList(constructor));
    }
    
    
    private Constructor<?>[] getConstructors()
    {
        return object.getClass().getDeclaredConstructors();
    }
    
    
    private Stream<Constructor<?>> getStreamForConstructors()
    {
        return Arrays.stream(getConstructors());
    }
    
    
    private Annotation[] getConstructorAnnotations(Constructor<?> constructor)
    {
        return constructor.getAnnotations();
    }
    
    
    private void appendConstructorAnnotationsToList(Annotation[] annotations)
    {
        allObjectConstructorsAnnotationsList.addAll(Arrays.asList(annotations));
    }
    
    
    private void getConstructorAnnotationsAndAppendThemToList(Constructor<?> constructor)
    {
        appendConstructorAnnotationsToList(getConstructorAnnotations(constructor));
    }
}