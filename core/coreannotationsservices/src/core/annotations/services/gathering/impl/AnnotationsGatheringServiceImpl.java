package core.annotations.services.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    @Override
    public List<Annotation> gatherAllAnnotationsFromObject(Object OrionObject)
    {
        return new GatherAllAnnotationsFromObjectTask().run(OrionObject);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public Annotation extractAnnotationFromMethod(Method method, Class annotationClassToExtract)
    {
        return ExtractAnnotationFromMethodTask.run(method, annotationClassToExtract);
    }
}