package core.annotations.services.registry.tasks;

import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.registry.AnnotationsRegistry;

public class RegisterAnnotationTask extends AnnotationObject implements AnnotationTask
{
    public void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}