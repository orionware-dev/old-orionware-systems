package core.annotations.registry.registerannotation;

import core.annotations.RegisteredAnnotation;
import core.annotations.registry.registerannotation.tasks.RegisterAnnotationTask;
import core.services.OrionServiceHelper;

public class RegisterAnnotationHelper implements OrionServiceHelper
{
    private RegisterAnnotationTask registerAnnotationTask = new RegisterAnnotationTask();
    
    
    public void run(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationTask.run(registeredAnnotation);
    }
}