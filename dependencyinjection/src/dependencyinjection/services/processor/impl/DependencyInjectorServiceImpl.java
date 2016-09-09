package dependencyinjection.services.processor.impl;

import dependencyinjection.services.DependencyInjectionServiceObject;
import dependencyinjection.services.processor.DependencyInjectorService;
import dependencyinjection.services.processor.impl.tasks.ProcessDependenciesTask;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }
}