package core.annotations.services.processor.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationToMethodTask;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationsToMethodTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private ApplyAnnotationsToMethodTask applyAnnotationsToMethodTask;
    private AnnotationsGatheringService annotationsGatheringService;
    private ApplyAnnotationToMethodTask applyAnnotationToMethodTask;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        this.applyAnnotationsToMethodTask = new ApplyAnnotationsToMethodTask();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        this.applyAnnotationToMethodTask = new ApplyAnnotationToMethodTask();
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
    }
    
    
    @Override
    public void processAllAnnotations(Object OrionObject)
    {
        List<Annotation> allObjectAnnotationsList = annotationsGatheringService.gatherAllAnnotationsFromObject(OrionObject);
        //we filter the annotations, because if it finds a registered annotation that matches
        //one in the list of object annotations then we can process it otherwise it means that Orion
        //will have to try to process non-Orion-based annotations like Java/Spring/etc. annotations
        //in which case it is processed by the respective framework
        Stream<OrionAnnotation> registeredAnnotations = annotationsGatheringService.filterRegisteredAnnotationsStreamFromObjectAnnotations(allObjectAnnotationsList);
        applyAnnotationsToMethodTask.run(registeredAnnotations, OrionObject);
    }
    
    
    //returns true if annotation has been applied to method and false if it is not registered
    @Override
    public boolean applyMethodAnnotation(Object OrionObject, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;
        
        if(annotationsGatheringService.isAnnotationRegisteredTask(annotationToProcess))
        {
            applyAnnotationToMethodTask.run(reflectionLoaderFacade, OrionObject, annotationToProcess);
            isAnnotationApplicable = true;
        }
        
        return isAnnotationApplicable;
    }
}