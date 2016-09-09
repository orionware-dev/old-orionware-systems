package dependencyinjection.services.processor;

import dependencyinjection.DependencyInjectionService;

public interface DependencyInjectorImplService extends DependencyInjectionService
{
    public void processDependencies(Object object);
}