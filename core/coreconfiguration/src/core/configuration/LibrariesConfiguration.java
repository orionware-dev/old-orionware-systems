package core.configuration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class LibrariesConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private static Set<LibraryConfiguration> librariesConfigurationSet;

    static
    {
        LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered = true;
        librariesConfigurationSet = Collections.synchronizedSet(new HashSet<LibraryConfiguration>());
    }


    public static Set<LibraryConfiguration> getLibrariesConfigurationSet()
    {
        return librariesConfigurationSet;
    }


    public static synchronized void registerLibraryConfiguration(LibraryConfiguration libraryConfiguration)
    {
        if(LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered)
        {
            getLibrariesConfigurationSet().add(libraryConfiguration);

            if(libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
            {
                LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered = false;
            }
        }
        else if(!libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
        {
            getLibrariesConfigurationSet().add(libraryConfiguration);
        }

        LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.put(libraryConfiguration.getLibraryClassPath(), true);
    }
}