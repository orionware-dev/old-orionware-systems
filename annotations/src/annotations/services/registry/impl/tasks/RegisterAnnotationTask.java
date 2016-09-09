package annotations.services.registry.impl.tasks;

import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.registry.AnnotationsRegistry;

public class RegisterAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}