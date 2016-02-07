package core.annotations.registry.registerannotation;

import core.annotations.RegisteredAnnotation;
import core.annotations.registry.registerannotation.tasks.RegisterAnnotationTask;
import core.services.OrionServiceCoordinator;

public class RegisterAnnotationCoordinator implements OrionServiceCoordinator
{
    private RegisterAnnotationTask registerAnnotationTask = new RegisterAnnotationTask();
    
    
    public void run(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationTask.run(registeredAnnotation);
    }
}