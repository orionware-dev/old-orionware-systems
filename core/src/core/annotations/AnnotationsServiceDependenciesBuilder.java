package core.annotations;

import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.general.ObjectDependenciesBuilder;

public class AnnotationsServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsServiceImpl object)
    {
        object.setAnnotationsConfigurationService(new AnnotationsConfigurationServiceImpl());
        object.setAnnotationsProcessorService(new AnnotationsProcessorServiceImpl());
    }
}