package configuration.registry.impl.tasks.libraries;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;

public class HaveConfigurationBeenRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public static boolean run(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.get(libraryClassPath) != null
                   && LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.get(libraryClassPath);
    }


    public static boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }
}