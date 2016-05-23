package core.dependencyinjection.service;

import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.service.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.service.tasks.ProcessServiceDependenciesTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionObject implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask;
    private ReflectionService reflectionService;
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask;
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public ServiceDependencyInjectorServiceImpl()
    {
        processServiceDependenciesTask = new ProcessServiceDependenciesTask();
        reflectionService = new ReflectionServiceImpl();
        processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
        annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    }
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        processServiceDependenciesTask.run(object, reflectionService, processMethodForServiceInjectionTask, annotationsProcessorService);
    }
}