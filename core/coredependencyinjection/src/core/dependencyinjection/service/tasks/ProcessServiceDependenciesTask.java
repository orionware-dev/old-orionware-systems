package core.dependencyinjection.service.tasks;

import java.util.Arrays;
import core.annotations.services.gathering.AnnotationsGatheringService;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.loader.ReflectionService;

public class ProcessServiceDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionService reflectionService, ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask, AnnotationsGatheringService annotationsGatheringService)
    {
        Arrays.stream(reflectionService.getMethodsArray(object))
            .forEach((method) -> processMethodForServiceInjectionTask.run(object, method, reflectionService, annotationsGatheringService));
    }
}