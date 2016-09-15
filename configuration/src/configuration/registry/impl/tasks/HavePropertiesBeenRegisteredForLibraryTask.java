package configuration.registry.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;

public class HavePropertiesBeenRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public boolean run(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath) != null
                   && LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath);
    }


    public boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }
}