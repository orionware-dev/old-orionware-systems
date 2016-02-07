package core.annotations.registry.haveannotationsbeenregisteredforlibrary;

import core.annotations.registry.haveannotationsbeenregisteredforlibrary.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.services.OrionServiceHelper;

public class HaveAnnotationsBeenRegisteredForLibraryHelper implements OrionServiceHelper
{
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryTask.run(libraryName);
    }
}