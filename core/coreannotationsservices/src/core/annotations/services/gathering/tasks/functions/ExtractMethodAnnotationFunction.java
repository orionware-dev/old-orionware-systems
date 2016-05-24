package core.annotations.services.gathering.tasks.functions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.functions.OrionAbstractFunction;

public class ExtractMethodAnnotationFunction extends OrionAbstractFunction
{
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}