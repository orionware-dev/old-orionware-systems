package core.annotations.services.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(Stream<LibraryConfiguration> librariesConfiguration)
    {
        HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        return librariesConfiguration.filter((libraryConfiguration) -> haveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryName()));
    }
}