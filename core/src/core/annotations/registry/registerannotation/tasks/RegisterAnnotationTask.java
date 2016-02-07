package core.annotations.registry.registerannotation.tasks;

import core.annotations.RegisteredAnnotation;
import core.registry.OrionRegistry;
import core.services.OrionTask;

public class RegisterAnnotationTask implements OrionTask
{
    public void run(RegisteredAnnotation registeredAnnotation)
    {
        OrionRegistry.registerAnnotation(registeredAnnotation);
    }
}