package core.dependencyinjection.facades.processor;

import core.dependencyinjection.DependencyInjectionFacade;

public interface DependencyInjectorFacade extends DependencyInjectionFacade
{
    public void processDependencies(Object object);
}