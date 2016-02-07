package core.annotations.registry.registerlibraryannotations;

import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.registerlibraryannotations.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceHelper;

public class RegisterLibraryAnnotationsHelper implements OrionServiceHelper
{
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    
    
    public void run(AnnotationsRegistrationService annotationsRegistrationService, AnnotationsLoaderService annotationsLoaderService, LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsTask.run(annotationsRegistrationService, annotationsLoaderService, libraryConfiguration);
    }
}