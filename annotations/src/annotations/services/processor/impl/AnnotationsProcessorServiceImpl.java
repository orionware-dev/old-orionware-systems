package annotations.services.processor.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.gathering.AnnotationsGatheringService;
import annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import annotations.services.processor.AnnotationsProcessorService;
import annotations.services.processor.impl.tasks.ApplyAnnotationToObjectTask;
import annotations.services.processor.impl.tasks.ApplyAnnotationsToObjectTask;
import annotations.services.processor.impl.tasks.GetAnnotationNameTask;
import annotations.services.registry.AnnotationsRegistrationService;
import annotations.services.registry.impl.AnnotationsRegistrationServiceImpl;

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