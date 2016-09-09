package dependencyinjection.services.processor.impl;

import dependencyinjection.services.DependencyInjectionServiceObject;
import dependencyinjection.services.processor.DependencyInjectorImplService;
import dependencyinjection.services.processor.impl.tasks.ProcessDependenciesTask;

public class DependencyInjectorImplServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorImplService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object);
    }
}