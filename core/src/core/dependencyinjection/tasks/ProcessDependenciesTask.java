package core.dependencyinjection.tasks;

import java.lang.reflect.Method;
import java.util.Arrays;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.dependencyinjection.Injector;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessDependenciesTask implements OrionTask
{
    public void run(OrionObject object, ReflectionService reflectionService, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsProcessorService annotationsProcessorService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForInjectionTask.run(object, method, reflectionService, annotationsProcessorService));
    }
}