package core;

import java.util.HashSet;
import core.annotations.AnnotationsServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;

public class OrionObjectDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(OrionObject object)
    {
        object.setLibrariesConfigurationSet(new HashSet<LibraryConfiguration>());
        object.setLibraryConfiguration(new LibraryConfiguration());
        object.setLibraryService(new LibraryServiceImpl());
        object.setConfigurationService(new ConfigurationServiceImpl());
        object.setAnnotationsService(new AnnotationsServiceImpl());
    }
}