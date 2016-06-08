package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class HavePropertiesBeenRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public static synchronized boolean run(String libraryClassPath)
    {
        if(libraryPropertiesHaveBeenRegistered(libraryClassPath))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath);
        }
        else
        {
            return false;
        }
    }
    
    
    public static synchronized boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }
    
    
    private static boolean libraryPropertiesHaveBeenRegistered(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath) != null;
    }
}