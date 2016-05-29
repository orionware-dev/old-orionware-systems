package core.dependencyinjection.services.service;

import core.dependencyinjection.DependencyInjectionService;

public interface ServiceDependencyInjectorService extends DependencyInjectionService
{
    public void processServiceDependencies(Object object);
}