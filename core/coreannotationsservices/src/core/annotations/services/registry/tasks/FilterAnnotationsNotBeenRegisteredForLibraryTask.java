package core.annotations.services.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(AnnotationsRegistrationService annotationsRegistrationService, Stream<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.filter((libraryConfiguration) -> annotationsRegistrationService.haveAnnotationsNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()));
    }
}