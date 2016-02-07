package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    private GatherAllObjectAnnotationsTask gatherAllObjectAnnotationsTask = new GatherAllObjectAnnotationsTask();
    private ApplyAnnotationsTask applyAnnotationsTask = new ApplyAnnotationsTask();
    
    
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = gatherAllObjectAnnotationsTask.run(OrionObject);
        applyAnnotationsTask.run(this, OrionObject, allObjectAnnotationsList);
    }
    
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return method.getAnnotation(annotationClassToExtract);
    }
}