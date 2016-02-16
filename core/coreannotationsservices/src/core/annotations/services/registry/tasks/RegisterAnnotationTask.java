package core.annotations.services.registry.tasks;

import core.annotations.OrionAnnotation;
import core.annotations.services.registry.AnnotationsRegistry;
import core.OrionSimpleObject;
import core.annotations.AnnotationTask;

public class RegisterAnnotationTask extends OrionSimpleObject implements AnnotationTask
{
    public void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}