package core.annotations.registry;

import core.annotations.registry.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.registry.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.general.ObjectDependenciesBuilder;

public class AnnotationsRegistrationServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsRegistrationServiceImpl object)
    {
        object.setHaveAnnotationsBeenRegisteredForLibraryTask(new HaveAnnotationsBeenRegisteredForLibraryTask());
        object.setSetAnnotationsAsRegisteredForLibraryTask(new SetAnnotationsAsRegisteredForLibraryTask());
    }
}