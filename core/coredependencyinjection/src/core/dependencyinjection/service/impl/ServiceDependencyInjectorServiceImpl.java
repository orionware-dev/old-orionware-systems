package core.dependencyinjection.service.impl;

import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.service.ServiceDependencyInjectorService;
import core.dependencyinjection.service.impl.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.service.impl.tasks.ProcessServiceDependenciesTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.impl.ReflectionServiceImpl;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionObject implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask;
    private ReflectionService reflectionService;
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask;
    private AnnotationsGatheringService annotationsGatheringService;
    
    
    public ServiceDependencyInjectorServiceImpl()
    {
        this.processServiceDependenciesTask = new ProcessServiceDependenciesTask();
        this.reflectionService = new ReflectionServiceImpl();
        this.processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        processServiceDependenciesTask.run(object, reflectionService, processMethodForServiceInjectionTask, annotationsGatheringService);
    }
}