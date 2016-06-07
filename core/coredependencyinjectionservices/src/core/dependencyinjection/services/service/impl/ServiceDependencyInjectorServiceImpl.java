package core.dependencyinjection.services.service.impl;

import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.service.ServiceDependencyInjectorService;
import core.dependencyinjection.services.service.impl.tasks.ProcessServiceDependenciesTask;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements ServiceDependencyInjectorService
{
    @Override
    public void processServiceDependencies(Object object)
    {
        new ProcessServiceDependenciesTask().run(object);
    }
}