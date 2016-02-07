package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import core.OrionObject;
import core.annotations.processor.extractannotationfrommethod.ExtractAnnotationFromMethodHelper;
import core.annotations.processor.processallannotations.ProcessAllAnnotationsHelper;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private ProcessAllAnnotationsHelper processAllAnnotationsHelper = new ProcessAllAnnotationsHelper();
    private ExtractAnnotationFromMethodHelper extractAnnotationFromMethodHelper = new ExtractAnnotationFromMethodHelper();
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        processAllAnnotationsHelper.processAllAnnotations(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodHelper.extractAnnotationFromMethod(method, annotationClassToExtract);
    }
}