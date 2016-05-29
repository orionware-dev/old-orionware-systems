package core.dependencyinjection.facades.processor.impl;

import core.dependencyinjection.facades.DependencyInjectionFacadeObject;
import core.dependencyinjection.facades.processor.DependencyInjectorFacade;
import core.dependencyinjection.services.processor.DependencyInjectorService;
import core.dependencyinjection.services.processor.impl.DependencyInjectorServiceImpl;

public class DependencyInjectorFacadeImpl extends DependencyInjectionFacadeObject implements DependencyInjectorFacade
{
    @Override
    public void processDependencies(Object object)
    {
        new DependencyInjectorServiceImpl().processDependencies(object);
    }
}