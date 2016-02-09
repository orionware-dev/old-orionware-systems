package core.dependencyinjection.service;

import core.dependencyinjection.OrionDependencyInjectionService;

public interface ServiceDependencyInjectorService extends OrionDependencyInjectionService
{
    public void processServiceDependencies(Object object);
}