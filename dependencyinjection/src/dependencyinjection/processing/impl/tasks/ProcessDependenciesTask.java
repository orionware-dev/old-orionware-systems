package dependencyinjection.processing.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object)
    {
        ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        ProcessInstanceVariableForInjectionTask processInstanceVariableForInjectionTask = new ProcessInstanceVariableForInjectionTask();
        ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService = new ReflectionInstanceVariablesRetrievalServiceImpl();

        List<Field> fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(object);
        fields.forEach(field -> processInstanceVariableForInjectionTask.run(object, field));
        List<Method> methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethods(object);
        methods.forEach(method -> processMethodForInjectionTask.run(object, method));

        ProcessMethodForInjectionImplTask processMethodForInjectionImplTask = new ProcessMethodForInjectionImplTask();
        ProcessInstanceVariableForInjectionImplTask processInstanceVariableForInjectionImplTask = new ProcessInstanceVariableForInjectionImplTask();

        fields.forEach(field -> processInstanceVariableForInjectionImplTask.run(object, field));
        methods.forEach(method -> processMethodForInjectionImplTask.run(object, method));
    }
}