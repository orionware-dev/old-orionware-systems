package annotations.registry.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibraryConfiguration;

public class FilterNotNullLibrariesConfigurationTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream().filter(libraryConfiguration -> libraryConfiguration.getAnnotationsDefinitionFilePath() != null);
    }
}