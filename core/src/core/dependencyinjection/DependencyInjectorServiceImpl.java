package core.dependencyinjection;

import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.dependencyinjection.tasks.ProcessMethodForInjectionTask;
import core.reflection.ReflectionService;

public class DependencyInjectorServiceImpl implements DependencyInjectorService
{
    private ProcessDependenciesTask processDependenciesTask;
    private ReflectionService reflectionService;
    private ProcessMethodForInjectionTask processMethodForInjectionTask;
    private AnnotationsProcessorService annotationsProcessorService;
    
    
    public DependencyInjectorServiceImpl()
    {
        new DependencyInjectorServiceDependenciesBuilder().injectDependencies(this);
    }
    
    
    @Override
    public void processDependencies(OrionObject object)
    {
        processDependenciesTask.run(object, reflectionService, processMethodForInjectionTask, annotationsProcessorService);
    }


    public void setProcessDependenciesTask(ProcessDependenciesTask processDependenciesTask)
    {
        this.processDependenciesTask = processDependenciesTask;
    }


    public void setReflectionService(ReflectionService reflectionService)
    {
        this.reflectionService = reflectionService;
    }


    public void setProcessMethodForInjectionTask(ProcessMethodForInjectionTask processMethodForInjectionTask)
    {
        this.processMethodForInjectionTask = processMethodForInjectionTask;
    }


    public void setAnnotationsProcessorService(AnnotationsProcessorService annotationsProcessorService)
    {
        this.annotationsProcessorService = annotationsProcessorService;
    }
}