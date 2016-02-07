package core.annotations.registry.registerlibraryannotations;

import core.annotations.registry.registerlibraryannotations.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceHelper;

public class RegisterLibraryAnnotationsHelper implements OrionServiceHelper
{
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    
    
    public void run(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsTask.run(libraryConfiguration);
    }
}