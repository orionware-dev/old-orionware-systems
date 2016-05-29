package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetPropertiesAsRegisteredForLibraryTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}