package designpatterns;

import core.dependencyinjection.DependencyInjectorFacadeImpl;
import core.orion.OrionObject;

public abstract class DesignPatternObject extends OrionObject
{
    public DesignPatternObject()
    {
        new DependencyInjectorFacadeImpl().processDependencies(this);
    }
}