package core.annotations.registry.haveannotationsbeenregisteredforlibrary;

import core.annotations.registry.haveannotationsbeenregisteredforlibrary.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.services.OrionServiceCoordinator;

public class HaveAnnotationsBeenRegisteredForLibraryCoordinator implements OrionServiceCoordinator
{
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
    
    
    public boolean run(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryTask.run(libraryName);
    }
}