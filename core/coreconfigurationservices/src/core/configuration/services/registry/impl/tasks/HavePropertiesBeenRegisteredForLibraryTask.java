package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class HavePropertiesBeenRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
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
    
    
    public boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryName());
    }
    
    
    private boolean libraryPropertiesHaveBeenRegistered(String libraryName)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null;
    }
}