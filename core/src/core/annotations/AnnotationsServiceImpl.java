package core.annotations;

import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.configuration.AnnotationsConfigurationServiceImpl;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;

public class AnnotationsServiceImpl implements AnnotationsService
{
    @Override
    public AnnotationsConfigurationService getAnnotationsConfigurationService()
    {
        return new AnnotationsConfigurationServiceImpl();
    }

    
    @Override
    public AnnotationsProcessorService getAnnotationsProcessorService()
    {
        return new AnnotationsProcessorServiceImpl();
    }
}