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
        Constructor<?>[] constructors = object.getClass().getDeclaredConstructors();
        Stream<Constructor<?>> constructorsStream = Arrays.stream(constructors);
        constructorsStream.forEach((constructor) -> getConstructorAnnotationsAndAppendThemToList(constructor));
        return allObjectConstructorsAnnotationsList;
    }
    
    
    private void getConstructorAnnotationsAndAppendThemToList(Constructor<?> constructor)
    {
        Annotation[] annotations = constructor.getAnnotations();
        allObjectConstructorsAnnotationsList.addAll(Arrays.asList(annotations));
    }
}