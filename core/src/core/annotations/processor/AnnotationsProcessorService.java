package core.annotations.processor;

import core.OrionObject;
import core.reflection.ReflectionService;
import core.services.OrionService;

public interface AnnotationsProcessorService extends OrionService
{
    public void processAllAnnotations(OrionObject OrionObject);
    
    
    public ReflectionService getReflectionService();
}