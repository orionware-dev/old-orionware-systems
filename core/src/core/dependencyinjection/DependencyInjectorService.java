package core.dependencyinjection;

import core.OrionObject;
import core.services.OrionService;

public interface DependencyInjectorService extends OrionService
{
    public void processDependencies(OrionObject object);
}