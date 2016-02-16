package core.dependencyinjection.processor;

import core.OrionSimpleObject;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.annotations.services.processor.AnnotationsProcessorServiceImpl;
import core.dependencyinjection.processor.tasks.ProcessDependenciesTask;
import core.dependencyinjection.processor.tasks.ProcessMethodForInjectionTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class DependencyInjectorServiceImpl extends OrionSimpleObject implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask = new ProcessDependenciesTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    private ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void processDependencies(Object object)
    {
        processDependenciesTask.run(object, reflectionService, processMethodForInjectionTask, annotationsProcessorService);
    }
}