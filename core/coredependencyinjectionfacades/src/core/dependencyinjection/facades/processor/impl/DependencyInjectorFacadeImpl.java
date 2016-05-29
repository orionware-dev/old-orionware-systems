package core.dependencyinjection.facades.processor.impl;

import core.dependencyinjection.facades.DependencyInjectionFacadeObject;
import core.dependencyinjection.facades.processor.DependencyInjectorFacade;
import core.dependencyinjection.services.processor.DependencyInjectorService;
import core.dependencyinjection.services.processor.impl.DependencyInjectorServiceImpl;

public class DependencyInjectorFacadeImpl extends DependencyInjectionFacadeObject implements DependencyInjectorFacade
{
    private DependencyInjectorService dependencyInjectorService;
    
    
    public DependencyInjectorFacadeImpl()
    {
        this.dependencyInjectorService = new DependencyInjectorServiceImpl();
    }
    
    
    @Override
    public void processDependencies(Object object)
    {
        dependencyInjectorService.processDependencies(object);
    }
}