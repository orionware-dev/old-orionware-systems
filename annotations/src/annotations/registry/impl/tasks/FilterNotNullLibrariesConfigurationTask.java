package annotations.registry.impl.tasks;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibraryConfiguration;

public class FilterNotNullLibrariesConfigurationTask extends AnnotationServiceObject implements AnnotationTask
{
    public List<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream().filter(libraryConfiguration -> libraryConfiguration.getAnnotationsDefinitionFilePath() != null).collect(Collectors.toList());
    }
}