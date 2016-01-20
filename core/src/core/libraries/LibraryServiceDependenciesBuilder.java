package core.libraries;

import core.general.ObjectDependenciesBuilder;
import core.libraries.tasks.IsCoreLibraryTask;

public class LibraryServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(LibraryServiceImpl object)
    {
        object.setIsCoreLibraryTask(new IsCoreLibraryTask());
    }
}