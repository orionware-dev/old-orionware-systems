package core.servicedependencyinjection;

import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;
import core.servicedependencyinjection.tasks.ProcessMethodForServiceInjectionTask;
import core.servicedependencyinjection.tasks.ProcessServiceDependenciesTask;

public class ServiceDependencyInjectorServiceImpl implements ServiceDependencyInjectorService
{
    private ProcessServiceDependenciesTask processServiceDependenciesTask = new ProcessServiceDependenciesTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    private ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask = new ProcessMethodForServiceInjectionTask();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void processServiceDependencies(OrionObject object)
    {
        processServiceDependenciesTask.run(object, reflectionService, processMethodForServiceInjectionTask, annotationsProcessorService);
    }
}