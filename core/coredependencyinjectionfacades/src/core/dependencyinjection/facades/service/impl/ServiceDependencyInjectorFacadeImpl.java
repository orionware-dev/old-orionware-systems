package core.dependencyinjection.facades.service.impl;

import core.dependencyinjection.facades.DependencyInjectionFacadeObject;
import core.dependencyinjection.facades.service.ServiceDependencyInjectorFacade;
import core.dependencyinjection.services.service.ServiceDependencyInjectorService;
import core.dependencyinjection.services.service.impl.ServiceDependencyInjectorServiceImpl;

public class ServiceDependencyInjectorFacadeImpl extends DependencyInjectionFacadeObject implements ServiceDependencyInjectorFacade
{
    private ServiceDependencyInjectorService serviceDependencyInjectorService;
    
    
    public ServiceDependencyInjectorFacadeImpl()
    {
        this.serviceDependencyInjectorService = new ServiceDependencyInjectorServiceImpl();
    }
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        serviceDependencyInjectorService.processServiceDependencies(object);
    }
}