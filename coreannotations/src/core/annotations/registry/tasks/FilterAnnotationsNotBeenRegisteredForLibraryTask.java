package core.annotations.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.registry.AnnotationsRegistrationService;
import core.configuration.LibraryConfiguration;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(AnnotationsRegistrationService annotationsRegistrationService, Stream<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.filter((libraryConfiguration) -> annotationsRegistrationService.haveAnnotationsNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()));
    }
}