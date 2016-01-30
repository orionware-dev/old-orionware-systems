package core;

import java.util.HashSet;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
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
        object.setAnnotationsConfigurationService(new AnnotationsConfigurationServiceImpl());
        object.setAnnotationsProcessorService(new AnnotationsProcessorServiceImpl());
    }
}