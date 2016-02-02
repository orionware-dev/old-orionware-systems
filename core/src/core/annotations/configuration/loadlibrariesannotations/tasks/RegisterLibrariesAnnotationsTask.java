package core.annotations.configuration.loadlibrariesannotations.tasks;

import java.util.stream.Stream;
import core.annotations.registry.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class RegisterLibrariesAnnotationsTask implements OrionTask
{
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    
    
    public void run(Stream<LibraryConfiguration> librariesConfiguration)
    {
        librariesConfiguration.forEach((libraryConfiguration) -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }
}