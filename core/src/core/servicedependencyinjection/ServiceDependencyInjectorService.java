package core.servicedependencyinjection;

import core.OrionObject;
import core.services.OrionService;

public interface ServiceDependencyInjectorService extends OrionService
{
    public void processServiceDependencies(OrionObject object);
}