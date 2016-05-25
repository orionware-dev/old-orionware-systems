package core.annotations.services.gathering.tasks;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.tasks.functions.ExtractAnnotationFromMethodFunction;

public class ExtractAnnotationFromMethodTask extends AnnotationServiceObject implements AnnotationTask
{
    private ExtractAnnotationFromMethodFunction extractAnnotationFromMethodFunction;
    
    
    public ExtractAnnotationFromMethodTask()
    {
        extractAnnotationFromMethodFunction = new ExtractAnnotationFromMethodFunction();
    }
    
    
    @SuppressWarnings({"rawtypes"})
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodFunction.run(method, annotationClassToExtract);
    }
}