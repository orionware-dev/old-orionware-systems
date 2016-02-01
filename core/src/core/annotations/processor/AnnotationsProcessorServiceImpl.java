package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
    private ApplyAnnotationsTask applyAnnotationsTask = new ApplyAnnotationsTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllObjectAnnotationsTask.run(OrionObject);
        applyAnnotationsTask.run(this, OrionObject, allObjectAnnotationsList);
    }
    
    
    @Override
    public ReflectionService getReflectionService()
    {
        return reflectionService;
    }
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}