package core.dependencyinjection.services.service.impl;

import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.service.ServiceDependencyInjectorService;
import core.dependencyinjection.services.service.impl.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.services.service.impl.tasks.ProcessServiceDependenciesTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    
    
    public ServiceDependencyInjectorServiceImpl()
    {
        this.processServiceDependenciesTask = new ProcessServiceDependenciesTask();
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        this.processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
        this.annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
    }
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        processServiceDependenciesTask.run(object, reflectionLoaderFacade, processMethodForServiceInjectionTask, annotationsGatheringFacade);
    }
}