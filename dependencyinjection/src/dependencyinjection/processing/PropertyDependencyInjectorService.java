package dependencyinjection.processing;

import dependencyinjection.DependencyInjectionService;

public interface PropertyDependencyInjectorService extends DependencyInjectionService
{
    public void processPropertyInjection(Object object);
}