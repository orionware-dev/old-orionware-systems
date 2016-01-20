package core.dependencyinjection;

import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.general.ObjectDependenciesBuilder;
import core.reflection.ReflectionServiceImpl;

public class DependencyInjectorServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(DependencyInjectorServiceImpl object)
    {
        object.setProcessDependenciesTask(new ProcessDependenciesTask());
        object.setReflectionService(new ReflectionServiceImpl());
    }
}