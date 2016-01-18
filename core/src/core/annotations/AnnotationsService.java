package core.annotations;

import core.annotations.configuration.AnnotationsConfigurationService;
import core.annotations.processor.AnnotationsProcessorService;
import core.services.OrionService;

public interface AnnotationsService extends OrionService
{
    public AnnotationsConfigurationService getAnnotationsConfigurationService();
    
    
    public AnnotationsProcessorService getAnnotationsProcessorService();
}