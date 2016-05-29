package core.dependencyinjection.services.service.impl;

import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.service.ServiceDependencyInjectorService;
import core.dependencyinjection.services.service.impl.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.services.service.impl.tasks.ProcessServiceDependenciesTask;
import core.reflection.facades.loader.ReflectionFacade;
import core.reflection.facades.loader.impl.ReflectionFacadeImpl;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask;
    private ReflectionFacade reflectionFacade;
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    
    
    public ServiceDependencyInjectorServiceImpl()
    {
        this.processServiceDependenciesTask = new ProcessServiceDependenciesTask();
        this.reflectionFacade = new ReflectionFacadeImpl();
        this.processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
        this.annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
    }
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        processServiceDependenciesTask.run(object, reflectionFacade, processMethodForServiceInjectionTask, annotationsGatheringFacade);
    }
}