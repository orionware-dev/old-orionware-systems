package dependencyinjection.processing.impl;

import dependencyinjection.DependencyInjectionServiceObject;
import dependencyinjection.processing.DependencyInjectorImplService;
import dependencyinjection.processing.impl.tasks.ProcessDependenciesTask;

public class DependencyInjectorImplServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorImplService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }
}