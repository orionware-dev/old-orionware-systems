package core.annotations;

import java.util.HashSet;
import core.OrionObject;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;

public class AnnotationsServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsServiceImpl object)
    {
        object.setAnnotationsConfigurationService(new AnnotationsConfigurationServiceImpl());
        object.setAnnotationsProcessorService(new AnnotationsProcessorServiceImpl());
    }
}