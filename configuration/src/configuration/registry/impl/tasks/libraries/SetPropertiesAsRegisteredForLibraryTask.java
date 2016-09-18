package configuration.registry.impl.tasks.libraries;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;

public class SetPropertiesAsRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run(String libraryClassPath)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryClassPath, true);
    }


    public static void run(LibraryConfiguration libraryConfiguration)
    {
        run(libraryConfiguration.getLibraryClassPath());
    }
}