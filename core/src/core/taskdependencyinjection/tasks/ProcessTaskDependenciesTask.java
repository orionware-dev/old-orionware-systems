package core.taskdependencyinjection.tasks;

import java.util.Arrays;
import core.OrionObject;
import core.annotations.processor.AnnotationsProcessorService;
import core.reflection.ReflectionService;
import core.services.OrionTask;

public class ProcessTaskDependenciesTask implements OrionTask
{
    public void run(OrionObject object, ReflectionService reflectionService, ProcessMethodForTaskInjectionTask processMethodForTaskInjectionTask, AnnotationsProcessorService annotationsProcessorService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForTaskInjectionTask.run(object, method, reflectionService, annotationsProcessorService));
    }
}