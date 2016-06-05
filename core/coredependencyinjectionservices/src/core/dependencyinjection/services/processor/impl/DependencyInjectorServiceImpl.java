package core.dependencyinjection.services.processor.impl;

import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.processor.DependencyInjectorService;
import core.dependencyinjection.services.processor.impl.tasks.ProcessDependenciesTask;
import core.dependencyinjection.services.processor.impl.tasks.ProcessMethodForInjectionTask;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class DependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements DependencyInjectorService
{
    @Override
    public void processDependencies(Object object)
    {
        new ProcessDependenciesTask().run(object, new ReflectionLoaderFacadeImpl(), new ProcessMethodForInjectionTask(), new AnnotationsGatheringFacadeImpl());
    }
}