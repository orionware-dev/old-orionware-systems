package core.annotations.services.gathering.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.gathering.impl.tasks.FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask;
import core.annotations.services.gathering.impl.tasks.GatherAllAnnotationsFromObjectTask;
import core.annotations.services.gathering.impl.tasks.IsAnnotationRegisteredTask;

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
        return new ExtractAnnotationFromMethodTask().run(method, annotationClassToExtract);
    }


    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList)
    {
        return new FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask().run(allObjectAnnotationsList);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return new IsAnnotationRegisteredTask().run(annotation);
    }
}