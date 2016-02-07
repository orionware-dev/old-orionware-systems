package core.annotations.processor.extractannotationfrommethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.processor.extractannotationfrommethod.tasks.ExtractAnnotationFromMethodTask;
import core.services.OrionServiceHelper;

public class ExtractAnnotationFromMethodHelper implements OrionServiceHelper
{
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
    
    
    @SuppressWarnings("rawtypes")
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}