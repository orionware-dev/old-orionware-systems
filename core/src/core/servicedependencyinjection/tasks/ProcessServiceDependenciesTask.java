package core.servicedependencyinjection.tasks;

import java.util.Arrays;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessServiceDependenciesTask implements OrionTask
{
    public void run(OrionObject object, ReflectionService reflectionService, ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask, AnnotationsProcessorService annotationsProcessorService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForServiceInjectionTask.run(object, method, reflectionService, annotationsProcessorService));
    }
}