package core.configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class LibrariesConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private static Set<LibraryConfiguration> librariesConfiguration;

    static
    {
        LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered = true;
        librariesConfiguration = Collections.synchronizedSet(new HashSet<LibraryConfiguration>());
    }


    public static Set<LibraryConfiguration> getLibrariesConfiguration()
    {
        return librariesConfiguration;
    }


    public static synchronized void registerLibraryConfiguration(LibraryConfiguration libraryConfiguration)
    {
        if(LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered)
        {
            getLibrariesConfiguration().add(libraryConfiguration);

            if(libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
            {
                LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered = false;
            }
        }
        else if(!libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
        {
            getLibrariesConfiguration().add(libraryConfiguration);
        }

        LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.put(libraryConfiguration.getLibraryClassPath(), true);
    }
}