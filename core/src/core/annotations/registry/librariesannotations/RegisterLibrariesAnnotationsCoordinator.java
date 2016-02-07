package core.annotations.registry.librariesannotations;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.librariesannotations.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.registry.librariesannotations.tasks.FilterNotNullLibraryConfigurationsTask;
import core.annotations.registry.librariesannotations.tasks.RegisterLibrariesAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceCoordinator;

public class RegisterLibrariesAnnotationsCoordinator implements OrionServiceCoordinator
{
    private FilterNotNullLibraryConfigurationsTask filterNotNullLibraryConfigurationsTask = new FilterNotNullLibraryConfigurationsTask();
    private FilterAnnotationsNotBeenRegisteredForLibraryTask filterAnnotationsNotBeenRegisteredForLibraryTask = new FilterAnnotationsNotBeenRegisteredForLibraryTask();
    private RegisterLibrariesAnnotationsTask registerLibrariesAnnotationsTask = new RegisterLibrariesAnnotationsTask();
    
    
    public void run(AnnotationsRegistrationService annotationsRegistrationService, AnnotationsLoaderService annotationsLoaderService, Set<LibraryConfiguration> librariesConfiguration)
    {
        Stream<LibraryConfiguration> notNullLibraryConfigurations = filterNotNullLibraryConfigurationsTask.run(librariesConfiguration);
        notNullLibraryConfigurations = filterAnnotationsNotBeenRegisteredForLibraryTask.run(annotationsRegistrationService, notNullLibraryConfigurations);
        registerLibrariesAnnotationsTask.run(annotationsRegistrationService, annotationsLoaderService, notNullLibraryConfigurations);
    }
}