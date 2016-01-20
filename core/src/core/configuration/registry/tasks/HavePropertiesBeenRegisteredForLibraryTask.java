package core.configuration.registry.tasks;

import core.configuration.LibrariesConfigurationMapper;
import core.services.OrionTask;

public class HavePropertiesBeenRegisteredForLibraryTask implements OrionTask
{
    public boolean run(String libraryName)
    {
        if(LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null)
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
}