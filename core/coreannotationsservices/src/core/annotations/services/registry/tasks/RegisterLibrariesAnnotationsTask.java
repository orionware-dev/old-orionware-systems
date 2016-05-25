package core.annotations.services.registry.tasks;

import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<LibraryConfiguration> librariesConfiguration)
    {
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        librariesConfiguration.forEach((libraryConfiguration) -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }
}