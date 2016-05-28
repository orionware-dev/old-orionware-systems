package core.dependencyinjection.processor.impl.tasks;

import java.util.Arrays;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.loader.ReflectionService;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionService reflectionService, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsGatheringService annotationsGatheringService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForInjectionTask.run(object, method, reflectionService, annotationsGatheringService));
    }
}