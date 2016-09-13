package annotations.processing.impl.tasks;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.registry.impl.AnnotationsRegistrationServiceImpl;

public class ApplyMethodAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(Object object, OrionAnnotation annotationToProcess)
    {
        boolean isAnnotationApplicable = false;

        if(new AnnotationsRegistrationServiceImpl().isAnnotationRegistered(annotationToProcess))
        {
            new ApplyAnnotationToObjectTask().run(object, annotationToProcess);
            isAnnotationApplicable = true;
        }

        return isAnnotationApplicable;
    }
}