package dependencyinjection.processing.impl;

import dependencyinjection.DependencyInjectionServiceObject;
import dependencyinjection.processing.PropertyDependencyInjectorService;
import dependencyinjection.processing.impl.tasks.ProcessPropertyDependenciesTask;

public class PropertyDependencyInjectorServiceImpl extends DependencyInjectionServiceObject implements PropertyDependencyInjectorService
{
    @Override
    public void processPropertyInjection(Object object)
    {
        new ProcessPropertyDependenciesTask().run(object);
    }
}