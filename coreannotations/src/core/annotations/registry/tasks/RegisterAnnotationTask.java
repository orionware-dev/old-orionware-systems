package core.annotations.registry.tasks;

import core.annotations.OrionAnnotationTask;
import core.annotations.RegisteredAnnotation;
import core.annotations.registry.AnnotationsRegistry;

public class RegisterAnnotationTask implements OrionAnnotationTask
{
    public void run(RegisteredAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}