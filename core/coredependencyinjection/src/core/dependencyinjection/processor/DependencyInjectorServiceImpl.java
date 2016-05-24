package core.dependencyinjection.processor;

import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.AnnotationsGatheringServiceImpl;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.processor.tasks.ProcessDependenciesTask;
import core.dependencyinjection.processor.tasks.ProcessMethodForInjectionTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.ReflectionServiceImpl;

public class DependencyInjectorServiceImpl extends DependencyInjectionObject implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask;
    private ReflectionService reflectionService;
    private ProcessMethodForInjectionTask processMethodForInjectionTask;
    private AnnotationsGatheringService annotationsGatheringService;
    
    
    public DependencyInjectorServiceImpl()
    {
        this.processDependenciesTask = new ProcessDependenciesTask();
        this.reflectionService = new ReflectionServiceImpl();
        this.processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        this.annotationsGatheringService = new AnnotationsGatheringServiceImpl();
    }
    
    
    @Override
    public void processDependencies(Object object)
    {
        processDependenciesTask.run(object, reflectionService, processMethodForInjectionTask, annotationsGatheringService);
    }
}