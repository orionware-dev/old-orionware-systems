package core.dependencyinjection.facades.processor;

import core.dependencyinjection.DependencyInjectionFacade;
import core.services.OrionFacade;

public interface DependencyInjectorFacade extends DependencyInjectionFacade
{
    public void processDependencies(Object object);
}