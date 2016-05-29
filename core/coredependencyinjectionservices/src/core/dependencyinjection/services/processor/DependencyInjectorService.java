package core.dependencyinjection.services.processor;

import core.dependencyinjection.DependencyInjectionService;

public interface DependencyInjectorService extends DependencyInjectionService
{
    public void processDependencies(Object object);
}