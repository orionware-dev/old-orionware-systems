package core.annotations.registry.tasks;

import core.annotations.OrionAnnotation;
import core.annotations.OrionAnnotationTask;
import core.annotations.registry.AnnotationsRegistry;

public class RegisterAnnotationTask implements OrionAnnotationTask
{
    public void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}