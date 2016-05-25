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
    
    
    public GatherAllObjectConstructorsAnnotationsFunction()
    {
        this.allObjectConstructorsAnnotationsList = new ArrayList<Annotation>();
    }
    
    
    public List<Annotation> run(Object object)
    {
        gatherConstructorsAnnotationsAndPutThemInAList(object);
        return allObjectConstructorsAnnotationsList;
    }
    
    
    private void gatherConstructorsAnnotationsAndPutThemInAList(Object object)
    {
        Constructor<?>[] constructorAnnotations = getConstructorsAnnotations(object);
        Stream<Constructor<?>> annotationsStream = createStreamForAnnotations(constructorAnnotations);
        annotationsStream.forEach((constructor) -> appendAnnotationsToList(constructor));
    }
    
    
    private Constructor<?>[] getConstructorsAnnotations(Object object)
    {
        return object.getClass().getDeclaredConstructors();
    }
    
    
    private Stream<Constructor<?>> createStreamForAnnotations(Constructor<?>[] annotations)
    {
        return Arrays.stream(getConstructorsAnnotations(annotations));
    }
    
    
    private void appendAnnotationsToList(Constructor<?> constructor)
    {
        allObjectConstructorsAnnotationsList.addAll(Arrays.asList(constructor.getAnnotations()));
    }
}