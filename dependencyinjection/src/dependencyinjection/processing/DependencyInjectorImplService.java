package dependencyinjection.processing;

import dependencyinjection.DependencyInjectionService;

public interface DependencyInjectorImplService extends DependencyInjectionService
{
    public void processDependencies(Object object);
}