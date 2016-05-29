package core.dependencyinjection.facades.service;

import core.services.OrionFacade;

public interface ServiceDependencyInjectorFacade extends OrionFacade
{
    public void processServiceDependencies(Object object);
}