package designpatterns.annotations.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyPipelineAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyPipelineAnnotationsTask;
import designpatterns.annotations.impl.tasks.ProcessInstanceVariableForEmptyPipelineInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessMethodForEmptyPipelineInjectionTask;

public class EmptyPipelineAnnotationServiceImpl extends DesignPatternsObject implements EmptyPipelineAnnotationService
{
    @Override
    public void processEmptyPipelineAnnotations(Object object)
    {
        new ProcessEmptyPipelineAnnotationsTask().run(object);
    }
    
    
    @Override
    public void processMethodForEmptyPipelineInjection(Object object, Method method)
    {
        new ProcessMethodForEmptyPipelineInjectionTask().run(object, method);
    }

    
    @Override
    public void processInstanceVariableForEmptyPipelineInjection(Object object, Field instanceVariable)
    {
        new ProcessInstanceVariableForEmptyPipelineInjectionTask().run(object, instanceVariable);
    }
}