package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class SetConfigurationAsRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public static synchronized void run(String libraryClassPath)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.put(libraryClassPath, true);
    }
    
    
    public static synchronized void run(LibraryConfiguration libraryConfiguration)
    {
        run(libraryConfiguration.getLibraryClassPath());
    }
}