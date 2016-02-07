package core.annotations.registry.setannotationsasregisteredforlibrary;

import core.annotations.registry.setannotationsasregisteredforlibrary.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.services.OrionServiceHelper;

public class SetAnnotationsAsRegisteredForLibraryHelper implements OrionServiceHelper
{
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    
    
    public void run(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryTask.run(libraryName);
    }
}