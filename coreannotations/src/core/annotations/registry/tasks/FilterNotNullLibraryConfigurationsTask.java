package core.annotations.registry.tasks;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.OrionAnnotationTask;
import core.configuration.LibraryConfiguration;

public class FilterNotNullLibraryConfigurationsTask implements OrionAnnotationTask
{
    public Stream<LibraryConfiguration> run(Set<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream()
                    .filter((libraryConfiguration) -> libraryConfiguration.getAnnotationsFilePath() != null);
    }
}