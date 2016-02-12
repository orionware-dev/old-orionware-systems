package core.dependencyinjection.service;

import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;
import core.dependencyinjection.service.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.service.tasks.ProcessServiceDependenciesTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class ServiceDependencyInjectorServiceImpl implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask = new ProcessServiceDependenciesTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void processServiceDependencies(Object object)
    {
        processServiceDependenciesTask.run(object, reflectionService, processMethodForServiceInjectionTask, annotationsProcessorService);
    }
}