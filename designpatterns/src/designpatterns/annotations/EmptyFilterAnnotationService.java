package designpatterns.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsService;

public interface EmptyFilterAnnotationService extends DesignPatternsService
{
    public void processEmptyFilterAnnotations(Object object);
    
    
    public void processMethodForEmptyFilterInjection(Object object, Method method);
    
    
    public void processInstanceVariableForEmptyFilterInjection(Object object, Field instanceVariable);
}