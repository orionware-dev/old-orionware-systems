package core.dependencyinjection.services.processor.impl;

import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.processor.DependencyInjectorService;
import core.dependencyinjection.services.processor.impl.tasks.ProcessDependenciesTask;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }
}