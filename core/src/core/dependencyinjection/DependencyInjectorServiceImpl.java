package core.dependencyinjection;

import core.OrionObject;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.reflection.ReflectionServiceImpl;

public class DependencyInjectorServiceImpl implements DependencyInjectorService
{
    @Override
    public void processDependencies(OrionObject object)
    {
        new ProcessDependenciesTask().execute(object, new ReflectionServiceImpl());
    }
}