package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import dependencyinjection.annotation.Injector;
import dependencyinjection.annotation.InjectorImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import reflection.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.methods.retrieval.ReflectionMethodsRetrievalService;

public class ProcessEmptyPipelineAnnotationsTask extends DesignPatternsObject implements DesignPatternsTask
{
    @Injector
    private ProcessMethodForEmptyPipelineInjectionTask processMethodForEmptyPipelineInjectionTask;
    @Injector
    private ProcessInstanceVariableForEmptyPipelineInjectionTask processInstanceVariableForEmptyPipelineInjectionTask;
    @InjectorImpl
    private ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService;
    @InjectorImpl
    private ReflectionMethodsRetrievalService reflectionMethodsRetrievalService;
    
    
    public void run(Object object)
    {
        List<Field> fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForEmptyPipelineInjectionTask.run(object, field));
        List<Method> methods = reflectionMethodsRetrievalService.getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyPipelineInjectionTask.run(object, method));
    }
}