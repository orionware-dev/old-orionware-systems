package core.dependencyinjection.services.service.impl.tasks;

import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;

public class ProcessServiceDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionLoaderFacade reflectionLoaderFacade, ProcessMethodForServiceInjectionTask processMethodForServiceInjectionTask, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object))
            .forEach((method) -> processMethodForServiceInjectionTask.run(object, method, reflectionLoaderFacade, annotationsGatheringFacade));
    }
}