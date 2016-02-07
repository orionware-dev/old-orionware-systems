package core.annotations.registry.setannotationsasregisteredforlibrary;

import core.annotations.registry.setannotationsasregisteredforlibrary.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.services.OrionServiceHelper;

public class SetAnnotationsAsRegisteredForLibraryHelper implements OrionServiceHelper
{
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryTask.run(libraryName);
    }
}