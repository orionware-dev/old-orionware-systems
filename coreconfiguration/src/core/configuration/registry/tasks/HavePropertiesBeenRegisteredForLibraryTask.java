package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;

public class HavePropertiesBeenRegisteredForLibraryTask implements OrionConfigurationTask
{
    public boolean run(String libraryName)
    {
        if(libraryPropertiesHaveBeenRegistered(libraryName))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private boolean libraryPropertiesHaveBeenRegistered(String libraryName)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null;
    }
}