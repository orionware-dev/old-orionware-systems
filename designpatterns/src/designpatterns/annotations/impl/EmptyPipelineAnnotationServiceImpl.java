package designpatterns.annotations.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import dependencyinjection.annotation.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyPipelineAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyPipelineAnnotationsTask;
import designpatterns.annotations.impl.tasks.ProcessInstanceVariableForEmptyPipelineInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessMethodForEmptyPipelineInjectionTask;

public class EmptyPipelineAnnotationServiceImpl extends DesignPatternsObject implements EmptyPipelineAnnotationService
{
    @Injector
    private ProcessEmptyPipelineAnnotationsTask processEmptyPipelineAnnotationsTask;
    @Injector
    private ProcessMethodForEmptyPipelineInjectionTask processMethodForEmptyPipelineInjectionTask;
    @Injector
    private ProcessInstanceVariableForEmptyPipelineInjectionTask processInstanceVariableForEmptyPipelineInjectionTask;
    
    
    @Override
    public void processEmptyPipelineAnnotations(Object object)
    {
        processEmptyPipelineAnnotationsTask.run(object);
    }
    
    
    @Override
    public void processMethodForEmptyPipelineInjection(Object object, Method method)
    {
        processMethodForEmptyPipelineInjectionTask.run(object, method);
    }

    
    @Override
    public void processInstanceVariableForEmptyPipelineInjection(Object object, Field instanceVariable)
    {
        processInstanceVariableForEmptyPipelineInjectionTask.run(object, instanceVariable);
    }
}