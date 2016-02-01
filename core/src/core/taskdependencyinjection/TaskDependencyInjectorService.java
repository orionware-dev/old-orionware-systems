package core.taskdependencyinjection;

import core.OrionObject;
import core.services.OrionService;

public interface TaskDependencyInjectorService extends OrionService
{
    public void processTaskDependencies(OrionObject object);
}