package designpatterns.annotations.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyFilterAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyFilterAnnotationsTask;
import designpatterns.annotations.impl.tasks.ProcessInstanceVariableForEmptyFilterInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessMethodForEmptyFilterInjectionTask;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsObject implements EmptyFilterAnnotationService
{
    @Override
    public void processEmptyFilterAnnotations(Object object)
    {
        new ProcessEmptyFilterAnnotationsTask().run(object);
    }

    
    @Override
    public void processMethodForEmptyFilterInjection(Object object, Method method)
    {
        new ProcessMethodForEmptyFilterInjectionTask().run(object, method);
    }

    
    @Override
    public void processInstanceVariableForEmptyFilterInjection(Object object, Field instanceVariable)
    {
        new ProcessInstanceVariableForEmptyFilterInjectionTask().run(object, instanceVariable);
    }
}