package core.annotations.services.registry.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class FilterAnnotationsNotBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public static Stream<LibraryConfiguration> run(Stream<LibraryConfiguration> librariesConfigurationStream)
    {
        HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        return librariesConfigurationStream.filter(libraryConfiguration -> !haveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryName()));
    }
    
    
    public static Stream<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfigurationStream)
    {
        return run(librariesConfigurationStream.stream());
    }
}