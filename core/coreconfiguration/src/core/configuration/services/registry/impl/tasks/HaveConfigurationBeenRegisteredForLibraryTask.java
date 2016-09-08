package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class HaveConfigurationBeenRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public boolean run(String libraryClassPath)
    {
        if(libraryPropertiesHaveBeenRegistered(libraryClassPath))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.get(libraryClassPath);
        }
        else
        {
            return false;
        }
    }


    public boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }


    private boolean libraryPropertiesHaveBeenRegistered(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.get(libraryClassPath) != null;
    }
}