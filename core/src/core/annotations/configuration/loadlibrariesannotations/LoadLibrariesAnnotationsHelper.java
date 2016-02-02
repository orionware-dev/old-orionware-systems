package core.annotations.configuration.loadlibrariesannotations;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.configuration.loadlibrariesannotations.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.configuration.loadlibrariesannotations.tasks.FilterNotNullLibraryConfigurationsTask;
import core.annotations.configuration.loadlibrariesannotations.tasks.RegisterLibrariesAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceHelper;

public class LoadLibrariesAnnotationsHelper implements OrionServiceHelper
{
    private FilterNotNullLibraryConfigurationsTask filterNotNullLibraryConfigurationsTask = new FilterNotNullLibraryConfigurationsTask();
    private FilterAnnotationsNotBeenRegisteredForLibraryTask filterAnnotationsNotBeenRegisteredForLibraryTask = new FilterAnnotationsNotBeenRegisteredForLibraryTask();
    private RegisterLibrariesAnnotationsTask registerLibrariesAnnotationsTask = new RegisterLibrariesAnnotationsTask();
    
    
    public void loadLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        Stream<LibraryConfiguration> notNullLibraryConfigurations = filterNotNullLibraryConfigurationsTask.run(librariesConfiguration);
        notNullLibraryConfigurations = filterAnnotationsNotBeenRegisteredForLibraryTask.run(notNullLibraryConfigurations);
        registerLibrariesAnnotationsTask.run(notNullLibraryConfigurations);
    }
}