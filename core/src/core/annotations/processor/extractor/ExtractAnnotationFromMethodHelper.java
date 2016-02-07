package core.annotations.processor.extractor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.annotations.processor.extractor.tasks.ExtractAnnotationFromMethodTask;
import core.services.OrionServiceHelper;

public class ExtractAnnotationFromMethodHelper implements OrionServiceHelper
{
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
    
    
    @SuppressWarnings("rawtypes")
    public Annotation run(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}