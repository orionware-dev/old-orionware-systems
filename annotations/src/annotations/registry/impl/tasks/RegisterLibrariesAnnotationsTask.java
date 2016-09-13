package annotations.registry.impl.tasks;

import java.util.stream.Stream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run()
    {
        Stream<LibraryConfiguration> notNullLibrariesConfigurationStream = new FilterNotNullLibrariesConfigurationTask().run(LibrariesConfiguration.getLibrariesConfiguration());
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        notNullLibrariesConfigurationStream.forEach(libraryConfiguration -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }
}