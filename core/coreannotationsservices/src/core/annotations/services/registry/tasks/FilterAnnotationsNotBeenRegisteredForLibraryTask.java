package core.annotations.services.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(Stream<LibraryConfiguration> librariesConfigurationStream)
    {
        HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        return librariesConfigurationStream.filter((libraryConfiguration) -> !haveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryName()));
    }
}