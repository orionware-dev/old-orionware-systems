package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.services.accessibleobjects.instancevariables.retrieval.ReflectionInstanceVariablesRetrievalService;
import reflection.services.accessibleobjects.instancevariables.retrieval.impl.ReflectionInstanceVariablesRetrievalServiceImpl;
import reflection.services.accessibleobjects.methods.retrieval.impl.ReflectionMethodsRetrievalServiceImpl;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object)
    {
        ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        ProcessInstanceVariableForInjectionTask processInstanceVariableForInjectionTask = new ProcessInstanceVariableForInjectionTask();
        ReflectionInstanceVariablesRetrievalService reflectionInstanceVariablesRetrievalService = new ReflectionInstanceVariablesRetrievalServiceImpl();

        Field[] fields = reflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariablesArray(object);
        Arrays.stream(fields).forEach(field -> processInstanceVariableForInjectionTask.run(object, field));
        Method[] methods = new ReflectionMethodsRetrievalServiceImpl().getDeclaredMethodsArray(object);
        Arrays.stream(methods).forEach(method -> processMethodForInjectionTask.run(object, method));

        ProcessMethodForInjectionImplTask processMethodForInjectionImplTask = new ProcessMethodForInjectionImplTask();
        ProcessInstanceVariableForInjectionImplTask processInstanceVariableForInjectionImplTask = new ProcessInstanceVariableForInjectionImplTask();

        Arrays.stream(fields).forEach(field -> processInstanceVariableForInjectionImplTask.run(object, field));
        Arrays.stream(methods).forEach(method -> processMethodForInjectionImplTask.run(object, method));
    }
}