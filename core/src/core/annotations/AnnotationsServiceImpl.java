package core.annotations;

import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.processor.AnnotationsProcessorService;

public class AnnotationsServiceImpl implements AnnotationsService
{
    private AnnotationsConfigurationService annotationsConfigurationService;
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public AnnotationsServiceImpl()
    {
        new AnnotationsServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public AnnotationsConfigurationService getAnnotationsConfigurationService()
    {
        return annotationsConfigurationService;
    }

    
    @Override
    public AnnotationsProcessorService getAnnotationsProcessorService()
    {
        return annotationsProcessorService;
    }


    public void setAnnotationsConfigurationService(AnnotationsConfigurationService annotationsConfigurationService)
    {
        this.annotationsConfigurationService = annotationsConfigurationService;
    }


    public void setAnnotationsProcessorService(AnnotationsProcessorService annotationsProcessorService)
    {
        this.annotationsProcessorService = annotationsProcessorService;
    }
}