package core.annotations.registry.haveannotationsbeenregisteredforlibrary.tasks;

import core.configuration.LibrariesConfigurationMapper;
import core.services.OrionTask;

public class HaveAnnotationsBeenRegisteredForLibraryTask implements OrionTask
{
    public boolean run(String libraryName)
    {
        if(thisLibraryAnnotationsHaveBeenRegistered(libraryName))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private boolean thisLibraryAnnotationsHaveBeenRegistered(String libraryName)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null;
    }
}