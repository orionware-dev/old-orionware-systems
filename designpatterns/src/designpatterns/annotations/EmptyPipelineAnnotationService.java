package designpatterns.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsService;

public interface EmptyPipelineAnnotationService extends DesignPatternsService
{
    public void processEmptyPipelineAnnotations(Object object);
    
    
    public void processMethodForEmptyPipelineInjection(Object object, Method method);
    
    
    public void processInstanceVariableForEmptyPipelineInjection(Object object, Field instanceVariable);
}