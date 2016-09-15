package designpatterns.annotations.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import dependencyinjection.annotation.Injector;
import dependencyinjection.annotation.InjectorImpl;
import designpatterns.DesignPatternsObject;
import designpatterns.DesignPatternsTask;
import reflection.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.methods.retrieval.ReflectionMethodsRetrievalService;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessEmptyFilterAnnotationsTask extends DesignPatternsObject implements DesignPatternsTask
{
    @Injector
    private ProcessInstanceVariableForEmptyFilterInjectionTask processInstanceVariableForEmptyFilterInjectionTask;
    @Injector
    private ProcessMethodForEmptyFilterInjectionTask processMethodForEmptyFilterInjectionTask;
    @InjectorImpl
    private ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService;
    @InjectorImpl
    private ReflectionMethodsRetrievalService reflectionMethodsRetrievalService;
    
    
    public void run(Object object)
    {
        List<Field> fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForEmptyFilterInjectionTask.run(object, field));
        List<Method> methods = reflectionMethodsRetrievalService.getDeclaredMethods(object);
        methods.forEach(method -> processMethodForEmptyFilterInjectionTask.run(object, method));
    }
}