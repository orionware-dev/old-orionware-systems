package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.OrionSimpleObject;
import core.configuration.LibrariesConfigurationMapper;

public class SetPropertiesAsRegisteredForLibraryTask extends OrionSimpleObject implements OrionConfigurationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}