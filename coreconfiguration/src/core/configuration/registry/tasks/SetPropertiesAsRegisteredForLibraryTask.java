package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetPropertiesAsRegisteredForLibraryTask implements OrionConfigurationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}