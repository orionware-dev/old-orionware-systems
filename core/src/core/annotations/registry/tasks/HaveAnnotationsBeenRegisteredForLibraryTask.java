package core.annotations.registry.tasks;

import core.configuration.LibrariesConfigurationMapper;
import core.services.OrionTask;

public class HaveAnnotationsBeenRegisteredForLibraryTask implements OrionTask
{
    public boolean run(String libraryName)
    {
        if(LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null)
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
}