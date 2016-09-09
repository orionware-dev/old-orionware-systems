package annotations.services.registry.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import annotations.AnnotationTask;
import annotations.services.AnnotationServiceObject;
import configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(Stream<LibraryConfiguration> librariesConfigurationStream)
    {
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        librariesConfigurationStream.forEach(libraryConfiguration -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }


    public void run(Collection<LibraryConfiguration> librariesConfigurationStream)
    {
        run(librariesConfigurationStream.stream());
    }
}