package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.extractor.ExtractAnnotationFromMethodHelper;
import core.annotations.processor.gatherer.GatherAllAnnotationsHelper;
import core.annotations.processor.process.ProcessAllAnnotationsHelper;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllAnnotationsHelper gatherAllAnnotationsHelper = new GatherAllAnnotationsHelper();
    private ProcessAllAnnotationsHelper processAllAnnotationsHelper = new ProcessAllAnnotationsHelper();
    private ExtractAnnotationFromMethodHelper extractAnnotationFromMethodHelper = new ExtractAnnotationFromMethodHelper();
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(OrionObject OrionObject)
    {
        return gatherAllAnnotationsHelper.run(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        processAllAnnotationsHelper.run(this, OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodHelper.run(method, annotationClassToExtract);
    }
}