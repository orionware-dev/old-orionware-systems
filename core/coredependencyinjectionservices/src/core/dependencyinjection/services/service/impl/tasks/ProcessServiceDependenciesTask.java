package core.dependencyinjection.services.service.impl.tasks;

import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionFacade;

public class ProcessServiceDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionFacade reflectionFacade, ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        Arrays.stream(reflectionFacade.getMethodsArray(object))
            .forEach((method) -> processMethodForServiceInjectionTask.run(object, method, reflectionFacade, annotationsGatheringFacade));
    }
}