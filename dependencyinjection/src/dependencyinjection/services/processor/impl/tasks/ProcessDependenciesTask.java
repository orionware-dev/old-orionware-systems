package dependencyinjection.services.processor.impl.tasks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import dependencyinjection.DependencyInjectionObject;
import dependencyinjection.DependencyInjectionTask;
import reflection.services.loader.ReflectionLoaderService;
import reflection.services.loader.impl.ReflectionLoaderServiceImpl;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object)
    {
        ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        ProcessInstanceVariableForInjectionTask processInstanceVariableForInjectionTask = new ProcessInstanceVariableForInjectionTask();
        ReflectionLoaderService reflectionLoaderService = new ReflectionLoaderServiceImpl();
        Field[] fields = reflectionLoaderService.getInstanceVariablesArray(object);
        Arrays.stream(fields).forEach(field -> processInstanceVariableForInjectionTask.run(object, field));
        Method[] methods = reflectionLoaderService.getMethodsArray(object);
        Arrays.stream(methods).forEach(method -> processMethodForInjectionTask.run(object, method));
    }
}