package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistry;

public class RegisterAnnotationTask extends AnnotationServiceObject implements AnnotationTask
{
    public static synchronized void run(OrionAnnotation registeredAnnotation)
    {
        AnnotationsRegistry.registerAnnotation(registeredAnnotation);
    }
}