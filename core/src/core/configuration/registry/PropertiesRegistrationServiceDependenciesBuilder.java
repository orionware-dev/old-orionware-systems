package core.configuration.registry;

import core.configuration.registry.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import core.configuration.registry.tasks.SetPropertiesAsRegisteredForLibraryTask;
import core.general.ObjectDependenciesBuilder;

public class PropertiesRegistrationServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(PropertiesRegistrationServiceImpl object)
    {
        object.setHavePropertiesBeenRegisteredForLibraryTask(new HavePropertiesBeenRegisteredForLibraryTask());
        object.setSetPropertiesAsRegisteredForLibraryTask(new SetPropertiesAsRegisteredForLibraryTask());
    }
}