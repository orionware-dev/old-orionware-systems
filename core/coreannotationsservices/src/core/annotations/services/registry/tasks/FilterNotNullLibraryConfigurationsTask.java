package core.annotations.services.registry.tasks;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.configuration.LibraryConfiguration;

public class FilterNotNullLibraryConfigurationsTask implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(Set<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream()
                    .filter((libraryConfiguration) -> libraryConfiguration.getAnnotationsFilePath() != null);
    }
}