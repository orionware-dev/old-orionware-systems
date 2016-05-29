package core.dependencyinjection.facades.service.impl;

import core.dependencyinjection.facades.DependencyInjectionFacadeObject;
import core.dependencyinjection.facades.service.ServiceDependencyInjectorFacade;
import core.dependencyinjection.services.service.impl.ServiceDependencyInjectorServiceImpl;

public class ServiceDependencyInjectorFacadeImpl extends DependencyInjectionFacadeObject implements ServiceDependencyInjectorFacade
{
    @Override
    public void processServiceDependencies(Object object)
    {
        new ServiceDependencyInjectorServiceImpl().processServiceDependencies(object);
    }
}