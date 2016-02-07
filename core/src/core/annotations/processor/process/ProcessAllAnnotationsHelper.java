package core.annotations.processor.process;

import java.lang.annotation.Annotation;
import java.util.List;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.process.tasks.ApplyAnnotationsTask;
import core.reflection.ReflectionService;
import core.services.OrionServiceHelper;

public class ProcessAllAnnotationsHelper implements OrionServiceHelper
{
    private ApplyAnnotationsTask applyAnnotationsTask = new ApplyAnnotationsTask();
    
    
    public void run(AnnotationsProcessorService annotationsProcessorService, ReflectionService reflectionService, OrionObject OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = annotationsProcessorService.gatherAllAnnotationsFromObject(OrionObject);
        applyAnnotationsTask.run(reflectionService, OrionObject, allObjectAnnotationsList);
    }
}