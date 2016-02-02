package core.annotations.configuration.loadlibrariesannotations.tasks;

import java.util.stream.Stream;
import core.annotations.registry.AnnotationsRegistrationService;
import core.annotations.registry.AnnotationsRegistrationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask implements OrionTask
{
    private AnnotationsRegistrationService annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    
    
    public Stream<LibraryConfiguration> run(Stream<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.filter((libraryConfiguration) -> annotationsRegistrationService.haveAnnotationsNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryName()));
    }
}