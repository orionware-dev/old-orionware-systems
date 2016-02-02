package core.annotations.configuration.registerannotation;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.RegisteredAnnotation;
import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.configuration.registerannotation.tasks.RegisterAnnotationTask;
import core.annotations.configuration.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.annotations.registry.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceHelper;

public class RegisterAnnotationHelper implements OrionServiceHelper
{
    private RegisterAnnotationTask registerAnnotationTask = new RegisterAnnotationTask();
    
    
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationTask.run(registeredAnnotation);
    }
}