package core.dependencyinjection.services.service.impl.tasks;

import java.util.Arrays;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ProcessServiceDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object)
    {
        ReflectionLoaderFacade reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object))
            .forEach(method -> processMethodForServiceInjectionTask.run(object, method));
    }
}