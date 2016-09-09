package annotations.services.registry.impl.tasks;

import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.registry.AnnotationsRegistry;

public class IsAnnotationRegisteredTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(OrionAnnotation annotation)
    {
        return AnnotationsRegistry.isAnnotationRegistered(annotation);
    }
}