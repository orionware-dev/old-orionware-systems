package core.dependencyinjection.processor.tasks;

import java.util.Arrays;
import core.annotations.services.processor.AnnotationsProcessorService;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.loader.ReflectionService;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionService reflectionService, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsProcessorService annotationsProcessorService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForInjectionTask.run(object, method, reflectionService, annotationsProcessorService));
    }
}