package core.dependencyinjection.services.processor.impl;

import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.processor.DependencyInjectorService;
import core.dependencyinjection.services.processor.impl.tasks.ProcessDependenciesTask;
import core.dependencyinjection.services.processor.impl.tasks.ProcessMethodForInjectionTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask;
    private ReflectionLoaderFacade reflectionLoaderFacade;
    private ProcessMethodForInjectionTask processMethodForInjectionTask;
    private AnnotationsGatheringFacade annotationsGatheringFacade;
    
    
    public DependencyInjectorServiceImpl()
    {
        this.processDependenciesTask = new ProcessDependenciesTask();
        this.reflectionLoaderFacade = new ReflectionLoaderFacadeImpl();
        this.processMethodForInjectionTask = new ProcessMethodForInjectionTask();
        this.annotationsGatheringFacade = new AnnotationsGatheringFacadeImpl();
    }
    
    
    @Override
    public void processDependencies(Object object)
    {
        processDependenciesTask.run(object, reflectionLoaderFacade, processMethodForInjectionTask, annotationsGatheringFacade);
    }
}