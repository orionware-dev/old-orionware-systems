package designpatterns.annotations.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import dependencyinjection.annotation.Injector;
import designpatterns.DesignPatternsObject;
import designpatterns.annotations.EmptyFilterAnnotationService;
import designpatterns.annotations.impl.tasks.ProcessEmptyFilterAnnotationsTask;
import designpatterns.annotations.impl.tasks.ProcessEmptyPipelineAnnotationsTask;
import designpatterns.annotations.impl.tasks.ProcessInstanceVariableForEmptyFilterInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessInstanceVariableForEmptyPipelineInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessMethodForEmptyFilterInjectionTask;
import designpatterns.annotations.impl.tasks.ProcessMethodForEmptyPipelineInjectionTask;

public class EmptyFilterAnnotationServiceImpl extends DesignPatternsObject implements EmptyFilterAnnotationService
{
    @Injector
    private ProcessEmptyFilterAnnotationsTask processEmptyFilterAnnotationsTask;
    @Injector
    private ProcessMethodForEmptyFilterInjectionTask processMethodForEmptyFilterInjectionTask;
    @Injector
    private ProcessInstanceVariableForEmptyFilterInjectionTask processInstanceVariableForEmptyFilterInjectionTask;
    
    
    @Override
    public void processEmptyFilterAnnotations(Object object)
    {
        processEmptyFilterAnnotationsTask.run(object);
    }

    
    @Override
    public void processMethodForEmptyFilterInjection(Object object, Method method)
    {
        processMethodForEmptyFilterInjectionTask.run(object, method);
    }

    
    @Override
    public void processInstanceVariableForEmptyFilterInjection(Object object, Field instanceVariable)
    {
        processInstanceVariableForEmptyFilterInjectionTask.run(object, instanceVariable);
    }
}