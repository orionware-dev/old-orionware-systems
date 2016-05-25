package core.annotations.services.gathering;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.tasks.DoesObjectHaveRegisteredAnnotationTask;
import core.annotations.services.gathering.tasks.ExtractAnnotationFromMethodTask;
import core.annotations.services.gathering.tasks.FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask;
import core.annotations.services.gathering.tasks.GatherAllAnnotationsFromObjectTask;
import core.annotations.services.gathering.tasks.IsAnnotationRegisteredTask;

public class AnnotationsGatheringServiceImpl extends AnnotationServiceObject implements AnnotationsGatheringService
{
    private GatherAllAnnotationsFromObjectTask gatherAllAnnotationsFromObjectTask;
    private ExtractAnnotationFromMethodTask extractAnnotationFromMethodTask;
    private FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask filterRegisteredAnnotationsStreamFromObjectAnnotationsTask;
    private DoesObjectHaveRegisteredAnnotationTask doesObjectHaveRegisteredAnnotationTask;
    private IsAnnotationRegisteredTask isAnnotationRegisteredTask;
    
    
    public AnnotationsGatheringServiceImpl()
    {
        this.gatherAllAnnotationsFromObjectTask = new GatherAllAnnotationsFromObjectTask();
        this.extractAnnotationFromMethodTask = new ExtractAnnotationFromMethodTask();
        this.filterRegisteredAnnotationsStreamFromObjectAnnotationsTask = new FilterRegisteredAnnotationsStreamFromObjectAnnotationsTask();
        this.doesObjectHaveRegisteredAnnotationTask = new DoesObjectHaveRegisteredAnnotationTask();
        this.isAnnotationRegisteredTask = new IsAnnotationRegisteredTask();
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


    @Override
    public Stream<OrionAnnotation> filterRegisteredAnnotationsStreamFromObjectAnnotations(List<Annotation> allObjectAnnotationsList)
    {
        return filterRegisteredAnnotationsStreamFromObjectAnnotationsTask.run(allObjectAnnotationsList);
    }


    @Override
    public boolean doesObjectHaveRegisteredAnnotationTask(List<Annotation> allObjectAnnotationsList, OrionAnnotation registeredAnnotation)
    {
        return doesObjectHaveRegisteredAnnotationTask.run(allObjectAnnotationsList, registeredAnnotation);
    }


    @Override
    public boolean isAnnotationRegisteredTask(OrionAnnotation annotation)
    {
        return isAnnotationRegisteredTask.run(annotation);
    }
}