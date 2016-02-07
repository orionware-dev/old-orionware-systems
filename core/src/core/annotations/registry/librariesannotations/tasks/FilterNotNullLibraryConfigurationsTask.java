package core.annotations.registry.librariesannotations.tasks;

import java.util.Set;
import java.util.stream.Stream;
import core.configuration.LibraryConfiguration;
import core.services.OrionTask;

public class FilterNotNullLibraryConfigurationsTask implements OrionTask
{
    public Stream<LibraryConfiguration> run(Set<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream()
                    .filter((libraryConfiguration) -> libraryConfiguration.getAnnotationsFilePath() != null);
    }
}