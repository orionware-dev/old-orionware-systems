package core.dependencyinjection;

import core.OrionObject;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.reflection.ReflectionService;

public class DependencyInjectorServiceImpl implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask;
    private ReflectionService reflectionService;
    
    
    public DependencyInjectorServiceImpl()
    {
        new DependencyInjectorServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public void processDependencies(OrionObject object)
    {
        processDependenciesTask.run(object, reflectionService);
    }


    public void setProcessDependenciesTask(ProcessDependenciesTask processDependenciesTask)
    {
        this.processDependenciesTask = processDependenciesTask;
    }


    public void setReflectionService(ReflectionService reflectionService)
    {
        this.reflectionService = reflectionService;
    }
}