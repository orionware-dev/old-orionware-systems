package dependencyinjection.services.processor;

import dependencyinjection.DependencyInjectionService;

public interface DependencyInjectorService extends DependencyInjectionService
{
    public void processDependencies(Object object);
}