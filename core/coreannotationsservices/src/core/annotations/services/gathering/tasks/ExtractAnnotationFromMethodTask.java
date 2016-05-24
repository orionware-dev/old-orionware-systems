package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.tasks.functions.ExtractMethodAnnotationFunction;

public class ExtractAnnotationFromMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    private ExtractMethodAnnotationFunction extractMethodAnnotationFunction;
    
    
    public ExtractAnnotationFromMethodTask()
    {
        extractMethodAnnotationFunction = new ExtractMethodAnnotationFunction();
    }
    
    
    @SuppressWarnings({"rawtypes"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return extractMethodAnnotationFunction.run(method, annotationClassToExtract);
    }
}