package core.dependencyinjection.processor;

import core.dependencyinjection.OrionDependencyInjectionService;

public interface DependencyInjectorService extends OrionDependencyInjectionService
{
    public void processDependencies(Object object);
}