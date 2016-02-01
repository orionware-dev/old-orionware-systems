package core.dependencyinjection;

import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.dependencyinjection.tasks.ProcessMethodForInjectionTask;
import core.reflection.ReflectionService;
import core.reflection.ReflectionServiceImpl;

public class DependencyInjectorServiceImpl implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask = new ProcessDependenciesTask();
    private ReflectionService reflectionService = new ReflectionServiceImpl();
    private ProcessMethodForInjectionTask processMethodForInjectionTask = new ProcessMethodForInjectionTask();
    private AnnotationsProcessorService annotationsProcessorService = new AnnotationsProcessorServiceImpl();
    
    
    @Override
    public void processDependencies(OrionObject object)
    {
        processDependenciesTask.run(object, reflectionService, processMethodForInjectionTask, annotationsProcessorService);
    }
}