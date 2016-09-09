package dependencyinjection.services.processor.impl.tasks;

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
        ReflectionLoaderService reflectionLoaderService = new ReflectionLoaderServiceImpl();
        Method[] methods = reflectionLoaderService.getMethodsArray(object);
        Arrays.stream(methods).forEach(method -> processMethodForInjectionTask.run(object, method));
    }
}