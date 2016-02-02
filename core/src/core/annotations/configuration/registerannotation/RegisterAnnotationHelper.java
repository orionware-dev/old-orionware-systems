package core.annotations.configuration.registerannotation;

import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.registerannotation.tasks.RegisterAnnotationTask;
import core.services.OrionServiceHelper;

public class RegisterAnnotationHelper implements OrionServiceHelper
{
    private RegisterAnnotationTask registerAnnotationTask = new RegisterAnnotationTask();
    
    
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationTask.run(registeredAnnotation);
    }
}