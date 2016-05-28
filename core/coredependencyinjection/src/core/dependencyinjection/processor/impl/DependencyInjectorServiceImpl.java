package core.dependencyinjection.processor.impl;

import core.annotations.services.gathering.AnnotationsGatheringService;
import core.annotations.services.gathering.impl.AnnotationsGatheringServiceImpl;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.processor.DependencyInjectorService;
import core.dependencyinjection.processor.impl.tasks.ProcessDependenciesTask;
import core.dependencyinjection.processor.impl.tasks.ProcessMethodForInjectionTask;
import core.reflection.loader.ReflectionService;
import core.reflection.loader.impl.ReflectionServiceImpl;

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