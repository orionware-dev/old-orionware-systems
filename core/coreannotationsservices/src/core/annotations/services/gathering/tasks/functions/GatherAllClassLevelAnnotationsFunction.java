package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.functions.OrionAbstractFunction;

public class GatherAllClassLevelAnnotationsFunction extends OrionAbstractFunction
{
    public List<Annotation> run(Object object)
    {
        return Arrays.asList(object.getClass().getAnnotations());
    }
}