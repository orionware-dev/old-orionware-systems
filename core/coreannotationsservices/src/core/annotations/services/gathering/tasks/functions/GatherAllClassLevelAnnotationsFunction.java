package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import core.functions.OrionAbstractFunction;

public class GatherAllClassLevelAnnotationsFunction extends OrionAbstractFunction
{
    public List<Annotation> run(Object object)
    {
        first(getClassLevelAnnotations(object)).then(convertThemToList());
        //getClassLevelAnnotations(object);
        //andConvertThemToList();
        return Arrays.asList(object.getClass().getAnnotations());
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