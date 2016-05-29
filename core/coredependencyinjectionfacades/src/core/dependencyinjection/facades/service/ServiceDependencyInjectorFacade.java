package core.dependencyinjection.facades.service;

import core.dependencyinjection.DependencyInjectionFacade;
import core.services.OrionFacade;

public interface ServiceDependencyInjectorFacade extends DependencyInjectionFacade
{
    public void processServiceDependencies(Object object);
}