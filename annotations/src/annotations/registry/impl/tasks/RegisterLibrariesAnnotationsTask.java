package annotations.registry.impl.tasks;

import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run()
    {
        List<LibraryConfiguration> notNullLibrariesConfiguration = new FilterNotNullLibrariesConfigurationTask().run(LibrariesConfiguration.getLibrariesConfiguration());
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        notNullLibrariesConfiguration.forEach(libraryConfiguration -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }
}