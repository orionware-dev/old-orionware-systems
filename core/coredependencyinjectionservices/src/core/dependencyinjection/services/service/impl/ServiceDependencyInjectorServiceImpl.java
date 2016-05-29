package core.dependencyinjection.services.service.impl;

import core.annotations.facades.gathering.impl.AnnotationsGatheringFacadeImpl;
import core.dependencyinjection.services.DependencyInjectionServiceObject;
import core.dependencyinjection.services.service.ServiceDependencyInjectorService;
import core.dependencyinjection.services.service.impl.tasks.ProcessMethodForServiceInjectionTask;
import core.dependencyinjection.services.service.impl.tasks.ProcessServiceDependenciesTask;
import core.reflection.facades.loader.impl.ReflectionLoaderFacadeImpl;

public class ServiceDependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements ServiceDependencyInjectorService
{
    @Override
    public void processServiceDependencies(Object object)
    {
        new ProcessServiceDependenciesTask().run(object, new ReflectionLoaderFacadeImpl(), new ProcessMethodForServiceInjectionTask(), new AnnotationsGatheringFacadeImpl());
    }
}