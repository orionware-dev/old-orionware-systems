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

public class ProcessPropertyDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    private ProcessMethodForPropertyInjectionTask processMethodForPropertyInjectionTask = new ProcessMethodForPropertyInjectionTask();
    private ProcessInstanceVariableForPropertyInjectionTask processInstanceVariableForPropertyInjectionTask = new ProcessInstanceVariableForPropertyInjectionTask();
    private static ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService = new ReflectionInstanceVariablesRetrievalServiceImpl();
    private static ReflectionMethodsRetrievalService reflectionMethodsRetrievalService = new ReflectionMethodsRetrievalServiceImpl();
    
    
    public void run(Object object)
    {
        List<Field> fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForPropertyInjectionTask.run(object, field));
        List<Method> methods = reflectionMethodsRetrievalService.getDeclaredMethods(object);
        methods.forEach(method -> processMethodForPropertyInjectionTask.run(object, method));
    }
}