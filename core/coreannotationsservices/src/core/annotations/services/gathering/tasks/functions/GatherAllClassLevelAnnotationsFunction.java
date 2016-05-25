package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import core.functions.OrionAbstractFunction;

public class GatherAllClassLevelAnnotationsFunction extends OrionAbstractFunction
{
    public List<Annotation> run(Object object)
    {
        return getClassLevelAnnotationsAndConvertThemToList(object);
    }
    
    
    private List<Annotation> getClassLevelAnnotationsAndConvertThemToList(Object object)
    {
        return convertThemToList(getClassLevelAnnotations(object));
    }
    
    
    private Annotation[] getClassLevelAnnotations(Object object)
    {
        return object.getClass().getAnnotations();
    }
    
    
    private List<Annotation> convertThemToList(Annotation[] classLevelAnnotations)
    {
        return Arrays.asList(classLevelAnnotations);
    }
}