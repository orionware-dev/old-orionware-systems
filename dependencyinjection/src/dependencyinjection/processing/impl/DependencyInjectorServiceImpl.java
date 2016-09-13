package dependencyinjection.processing.impl;

import dependencyinjection.DependencyInjectionServiceObject;
import dependencyinjection.processing.DependencyInjectorService;
import dependencyinjection.processing.impl.tasks.ProcessDependenciesTask;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }
}