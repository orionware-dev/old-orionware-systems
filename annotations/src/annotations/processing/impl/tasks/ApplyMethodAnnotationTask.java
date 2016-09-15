package annotations.processing.impl.tasks;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistrationService;
import annotations.registry.impl.AnnotationsRegistrationServiceImpl;

public class ApplyMethodAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    private static AnnotationsRegistrationService annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    
    
    public boolean run(Object object, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;

        if(annotationsRegistrationService.isAnnotationRegistered(annotationToProcess))
        {
            ApplyAnnotationToObjectTask.run(object, annotationToProcess);
            isAnnotationApplicable = true;
        }

        return isAnnotationApplicable;
    }
}