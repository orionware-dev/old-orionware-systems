package core.dependencyinjection.facades.processor;

import core.services.OrionFacade;

public interface DependencyInjectorFacade extends OrionFacade
{
    public void processDependencies(Object object);
}