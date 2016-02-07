package core.annotations.registry.setannotationsasregisteredforlibrary;

import core.annotations.registry.setannotationsasregisteredforlibrary.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.services.OrionServiceCoordinator;

public class SetAnnotationsAsRegisteredForLibraryCoordinator implements OrionServiceCoordinator
{
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    
    
    public void run(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryTask.run(libraryName);
    }
}