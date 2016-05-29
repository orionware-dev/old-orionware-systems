package core.dependencyinjection.facades.service;

import core.dependencyinjection.DependencyInjectionFacade;

public interface ServiceDependencyInjectorFacade extends DependencyInjectionFacade
{
    public void processServiceDependencies(Object object);
}