package core.annotations.services.registry.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public static synchronized void run(Stream<LibraryConfiguration> librariesConfigurationStream)
    {
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        librariesConfigurationStream.forEach(libraryConfiguration -> registerLibraryAnnotationsTask.run(libraryConfiguration));
    }
    
    
    public static synchronized void run(Collection<LibraryConfiguration> librariesConfigurationStream)
    {
        run(librariesConfigurationStream.stream());
    }
}