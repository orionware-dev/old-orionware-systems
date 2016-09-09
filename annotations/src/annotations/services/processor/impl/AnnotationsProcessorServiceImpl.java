package annotations.services.processor.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Stream;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.filtering.AnnotationsFilteringService;
import annotations.services.filtering.impl.AnnotationsFilteringServiceImpl;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import annotations.services.processor.AnnotationsProcessorService;
import annotations.services.processor.impl.tasks.ApplyAnnotationToMethodTask;
import annotations.services.processor.impl.tasks.ApplyAnnotationsToMethodTask;
import annotations.services.processor.impl.tasks.GetAnnotationNameTask;
import annotations.services.registry.AnnotationsRegistrationService;
import annotations.services.registry.impl.AnnotationsRegistrationServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private AnnotationsFilteringService annotationsFilteringService;
    private AnnotationsGatheringService annotationsGatheringService;
    private AnnotationsRegistrationService annotationsRegistrationService;
    private GetAnnotationNameTask getAnnotationNameTask;


    public AnnotationsProcessorServiceImpl()
    {
        this.annotationsFilteringService = new AnnotationsFilteringServiceImpl();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        this.annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
        this.getAnnotationNameTask = new GetAnnotationNameTask();
    }


    @Override
    public void processAllAnnotations(Object orionObject)
    {
        List<Annotation> allObjectAnnotations = annotationsGatheringService.gatherAllAnnotationsFromObject(orionObject);
        //we filter the annotations, because if it finds a registered
        //annotation that matches
        //one in the list of object annotations then we can process it
        //otherwise it means that Orion
        //will have to try to process non-Orion-based annotations like
        //Java/Spring/etc. annotations
        //in which case it is processed by the respective framework
        Stream<OrionAnnotation> registeredAnnotations = annotationsFilteringService.filterRegisteredAnnotationsFromObjectAnnotations(allObjectAnnotations);
        new ApplyAnnotationsToMethodTask().run(registeredAnnotations, orionObject);
    }


    //returns true if annotation has been applied to method and false if it is
    //not registered
    @Override
    public boolean applyMethodAnnotation(Object OrionObject, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;

        if(annotationsRegistrationService.isAnnotationRegistered(annotationToProcess))
        {
            new ApplyAnnotationToMethodTask().run(OrionObject, annotationToProcess);
            isAnnotationApplicable = true;
        }

        return isAnnotationApplicable;
    }


    @Override
    public String getAnnotationName(Annotation annotation)
    {
        return getAnnotationNameTask.run(annotation);
    }
}