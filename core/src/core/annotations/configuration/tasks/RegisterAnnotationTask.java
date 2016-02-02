package core.annotations.configuration.tasks;

import java.io.InputStream;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.registry.OrionRegistry;
import core.services.OrionTask;

public class RegisterAnnotationTask implements OrionTask
{
    public void run(RegisteredAnnotation registeredAnnotation)
    {
        OrionRegistry.registerAnnotation(registeredAnnotation);
    }
}