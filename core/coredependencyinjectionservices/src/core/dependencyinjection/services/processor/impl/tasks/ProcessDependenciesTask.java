package core.dependencyinjection.services.processor.impl.tasks;

import java.util.Arrays;
import core.annotations.facades.gathering.AnnotationsGatheringFacade;
import core.dependencyinjection.DependencyInjectionObject;
import core.dependencyinjection.DependencyInjectionTask;
import core.reflection.facades.loader.ReflectionLoaderFacade;

public class ProcessDependenciesTask extends DependencyInjectionObject implements DependencyInjectionTask
{
    public void run(Object object, ReflectionLoaderFacade reflectionLoaderFacade, ProcessMethodForInjectionTask processMethodForInjectionTask, AnnotationsGatheringFacade annotationsGatheringFacade)
    {
        Arrays.stream(reflectionLoaderFacade.getMethodsArray(object))
            .forEach(method -> processMethodForInjectionTask.run(object, method, reflectionLoaderFacade, annotationsGatheringFacade));
    }
}