package annotations.processing.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.gathering.AnnotationsGatheringService;
import annotations.gathering.impl.AnnotationsGatheringServiceImpl;
import annotations.processing.AnnotationsProcessorService;
import annotations.processing.impl.tasks.ApplyAnnotationToObjectTask;
import annotations.processing.impl.tasks.ApplyAnnotationsToObjectTask;
import annotations.processing.impl.tasks.GetAnnotationNameTask;
import annotations.registry.AnnotationsRegistrationService;
import annotations.registry.impl.AnnotationsRegistrationServiceImpl;

public class AnnotationsProcessorServiceImpl extends AnnotationServiceObject implements AnnotationsProcessorService
{
    private AnnotationsGatheringService annotationsGatheringService;
    private AnnotationsRegistrationService annotationsRegistrationService;
    private GetAnnotationNameTask getAnnotationNameTask;


    public AnnotationsProcessorServiceImpl()
    {
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
        this.annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
        this.getAnnotationNameTask = new GetAnnotationNameTask();
    }


    @Override
    public void processAllAnnotations(Object object)
    {
        List<OrionAnnotation> registeredAnnotationsForObject = annotationsGatheringService.gatherAllAnnotationsFromObject(object);
        new ApplyAnnotationsToObjectTask().run(registeredAnnotationsForObject, object);
    }


    //returns true if annotation has been applied to method and false if it is
    //not registered
    @Override
    public boolean applyMethodAnnotation(Object object, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;

        if(annotationsRegistrationService.isAnnotationRegistered(annotationToProcess))
        {
            new ApplyAnnotationToObjectTask().run(object, annotationToProcess);
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