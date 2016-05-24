package core.annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.gathering.tasks.GatherAllAnnotationsFromObjectTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    private GatherAllAnnotationsFromObjectTask gatherAllAnnotationsFromObjectTask;
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask;
    
    
    public AnnotationsGatheringServiceImpl()
    {
        this.gatherAllAnnotationsFromObjectTask = new GatherAllAnnotationsFromObjectTask();
        this.extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
    }
    
    
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return gatherAllAnnotationsFromObjectTask.run(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return extractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}