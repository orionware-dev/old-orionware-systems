package core.configuration.registry.tasks;

import core.configuration.LibrariesConfigurationMapper;
import core.services.OrionTask;

public class SetPropertiesAsRegisteredForLibraryTask implements OrionTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}