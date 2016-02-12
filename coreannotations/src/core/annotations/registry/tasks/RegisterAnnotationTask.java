package core.annotations.registry.tasks;

import core.annotations.OrionAnnotation;
import core.annotations.AnnotationTask;
import core.annotations.registry.AnnotationsRegistry;

public class RegisterAnnotationTask implements AnnotationTask
{
    public void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}