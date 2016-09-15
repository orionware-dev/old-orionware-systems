package annotations.registry.impl.tasks;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistry;

public class RegisterAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public static void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}