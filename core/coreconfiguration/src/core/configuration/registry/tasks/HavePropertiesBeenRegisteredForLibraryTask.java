package core.configuration.registry.tasks;

import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.OrionConfigurationTask;

public class HavePropertiesBeenRegisteredForLibraryTask extends ConfigurationObject implements OrionConfigurationTask
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