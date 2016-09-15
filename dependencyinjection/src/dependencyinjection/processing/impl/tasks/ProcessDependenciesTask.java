package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.methods.retrieval.ReflectionMethodsRetrievalService;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
    private ProcessInstanceVariableForInjectionTask processInstanceVariableForInjectionTask = new ProcessInstanceVariableForInjectionTask();
    private static ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService = new ReflectionInstanceVariablesRetrievalServiceImpl();
    private static ReflectionMethodsRetrievalService reflectionMethodsRetrievalService = new ReflectionMethodsRetrievalServiceImpl();
    private ProcessMethodForInjectionImplTask processMethodForInjectionImplTask = new ProcessMethodForInjectionImplTask();
    private ProcessInstanceVariableForInjectionImplTask processInstanceVariableForInjectionImplTask = new ProcessInstanceVariableForInjectionImplTask();
    
    
    public void run(Object object)
    {
        List<Field> fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForInjectionTask.run(object, field));
        fields.forEach(field -> processInstanceVariableForInjectionImplTask.run(object, field));
        List<Method> methods = reflectionMethodsRetrievalService.getDeclaredMethods(object);
        methods.forEach(method -> processMethodForInjectionTask.run(object, method));
        methods.forEach(method -> processMethodForInjectionImplTask.run(object, method));
    }
}