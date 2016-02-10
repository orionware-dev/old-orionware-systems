package core.annotations.registry.tasks;

import java.util.stream.Stream;
import core.annotations.OrionAnnotationTask;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask implements OrionAnnotationTask
{
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    
    
    public void run(AnnotationsRegistrationService annotationsRegistrationService, AnnotationsLoaderService annotationsLoaderService, Stream<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.forEach((libraryConfiguration) -> registerLibraryAnnotationsTask.run(annotationsRegistrationService, annotationsLoaderService, libraryConfiguration));
    }
}