package core.annotations.services.registry.impl.tasks;

import java.util.Collection;
import java.util.stream.Stream;
import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibraryConfiguration;

public class FilterNotNullLibrariesConfigurationTask extends AnnotationServiceObject implements AnnotationTask
{
    public Stream<LibraryConfiguration> run(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return librariesConfiguration.stream().filter(libraryConfiguration -> libraryConfiguration.getAnnotationsDefinitionFilePath() != null);
    }
}