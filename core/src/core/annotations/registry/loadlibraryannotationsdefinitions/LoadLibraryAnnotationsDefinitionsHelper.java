package core.annotations.registry.loadlibraryannotationsdefinitions;

import core.annotations.registry.loadlibraryannotationsdefinitions.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceHelper;

public class LoadLibraryAnnotationsDefinitionsHelper implements OrionServiceHelper
{
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
    
    
    public void run(LibraryConfiguration libraryConfiguration)
    {
        loadLibraryAnnotationsDefinitionsTask.run(libraryConfiguration);
    }
}