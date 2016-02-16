package core.configuration.registry.tasks;

import core.OrionSimpleObject;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.OrionConfigurationTask;

public class SetPropertiesAsRegisteredForLibraryTask extends OrionSimpleObject implements OrionConfigurationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_PROPERTIES_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}