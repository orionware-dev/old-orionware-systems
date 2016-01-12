package core.annotations.processor;

import java.lang.annotation.Annotation;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;

public class AnnotationsProcessorServiceImpl implements AnnotationsProcessorService
{
    @SuppressWarnings("unchecked")
    @Override
    public void processAllAnnotations(OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = (List<Annotation>)new GatherAllObjectAnnotationsTask().run(OrionObject);
        new ApplyAnnotationsTask().run(this, OrionObject, allObjectAnnotationsList);
    }
    
    
    @Override
    public ReflectionService getReflectionService()
    {
        return new ReflectionServiceImpl();
    }
}