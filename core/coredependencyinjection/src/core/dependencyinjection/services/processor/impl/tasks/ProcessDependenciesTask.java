package core.dependencyinjection.services.processor.impl.tasks;

import java.util.Arrays;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object)
    {
        ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        ReflectionLoaderFacade reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object)).forEach(method -> processMethodForInjectionTask.run(object, method));
    }
}