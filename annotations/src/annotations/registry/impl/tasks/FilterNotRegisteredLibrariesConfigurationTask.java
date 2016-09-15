package annotations.registry.impl.tasks;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibraryConfiguration;

public class FilterNotRegisteredLibrariesConfigurationTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        List<LibraryConfiguration> notNullLibrariesConfiguration = new FilterNotNullLibrariesConfigurationTask().run(librariesConfiguration);
        HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        return notNullLibrariesConfiguration.stream().filter(libraryConfiguration ->
                   !haveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration)).collect(Collectors.toList());
    }
}