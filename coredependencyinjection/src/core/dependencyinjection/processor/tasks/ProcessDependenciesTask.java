package core.dependencyinjection.processor.tasks;

import java.util.Arrays;
import core.annotations.processor.AnnotationsProcessorService;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.loader.ReflectionService;

public class ProcessDependenciesTask implements DependencyInjectionTask
{
    public void run(Object object, ReflectionService reflectionService, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsProcessorService annotationsProcessorService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForInjectionTask.run(object, method, reflectionService, annotationsProcessorService));
    }
}