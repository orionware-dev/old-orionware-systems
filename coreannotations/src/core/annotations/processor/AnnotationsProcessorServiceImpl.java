package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
    private ApplyAnnotationsTask applyAnnotationsTask = new ApplyAnnotationsTask();
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return gatherAllObjectAnnotationsTask.run(OrionObject);
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllAnnotationsFromObject(OrionObject);
        applyAnnotationsTask.run(reflectionService, OrionObject, allObjectAnnotationsList);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}