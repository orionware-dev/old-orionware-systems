package annotations.registry.impl.tasks;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistry;

public class IsAnnotationRegisteredTask extends AnnotationServiceObject implements AnnotationTask
{
    public static boolean run(OrionAnnotation annotation)
    {
        return AnnotationsRegistry.isAnnotationRegistered(annotation);
    }
}