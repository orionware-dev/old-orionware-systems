package core.annotations.registry.librariesannotations.tasks;

import java.util.stream.Stream;
import core.annotations.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask implements OrionTask
{
    public Stream<LibraryConfiguration> run(AnnotationsRegistrationService annotationsRegistrationService, Stream<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.filter((libraryConfiguration) -> annotationsRegistrationService.haveAnnotationsNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()));
    }
}