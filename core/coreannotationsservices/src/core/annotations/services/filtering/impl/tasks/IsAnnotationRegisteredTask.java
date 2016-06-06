package core.annotations.services.filtering.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistry;

public class IsAnnotationRegisteredTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(OrionAnnotation annotation)
    {
        return AnnotationsRegistry.isAnnotationRegistered(annotation);
    }
}