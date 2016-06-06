package core.annotations.services.processor.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.filtering.AnnotationsFilteringService;
import core.annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationToMethodTask;
import core.annotations.services.processor.impl.tasks.ApplyAnnotationsToMethodTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private AnnotationsFilteringService annotationsFilteringService;
    private AnnotationsGatheringService annotationsGatheringService;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    
    
    public AnnotationsProcessorServiceImpl()
    {
        this.annotationsFilteringService = new AnnotationsFilteringServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
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
        Stream<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsStreamFromObjectAnnotations(allObjectAnnotationsList);
        new ApplyAnnotationsToMethodTask().run(registeredAnnotations, OrionObject, reflectionLoaderFacade::loadAndInstantiateClass, reflectionLoaderFacade::callMethod);
    }
    
    
    //returns true if annotation has been applied to method and false if it is not registered
    @Override
    public boolean applyMethodAnnotation(Object OrionObject, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;
        
        if(annotationsFilteringService.isAnnotationRegistered(annotationToProcess))
        {
            new ApplyAnnotationToMethodTask().run(OrionObject, annotationToProcess, reflectionLoaderFacade::loadAndInstantiateClass, reflectionLoaderFacade::callMethod);
            isAnnotationApplicable = true;
        }
        
        return isAnnotationApplicable;
    }
}