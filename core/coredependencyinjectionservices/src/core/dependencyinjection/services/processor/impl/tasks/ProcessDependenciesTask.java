package core.dependencyinjection.services.processor.impl.tasks;

import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionFacade;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionFacade reflectionFacade, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        Arrays.stream(reflectionFacade.getMethodsArray(object))
            .forEach((method) -> processMethodForInjectionTask.run(object, method, reflectionFacade, annotationsGatheringFacade));
    }
}