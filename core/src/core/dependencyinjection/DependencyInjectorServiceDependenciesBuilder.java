package core.dependencyinjection;

import core.annotations.processor.AnnotationsProcessorServiceImpl;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.dependencyinjection.tasks.ProcessMethodForInjectionTask;
import core.general.ObjectDependenciesBuilder;
import core.reflection.ReflectionServiceImpl;

public class DependencyInjectorServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(DependencyInjectorServiceImpl object)
    {
        object.setProcessDependenciesTask(new ProcessDependenciesTask());
        object.setReflectionService(new ReflectionServiceImpl());
        object.setProcessMethodForInjectionTask(new ProcessMethodForInjectionTask());
        object.setAnnotationsProcessorService(new AnnotationsProcessorServiceImpl());
    }
}