package core.configuration;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import core.OrionSimpleObject;
import core.abstraction.OrionConfiguration;

public class LibrariesConfiguration extends OrionSimpleObject implements OrionConfiguration
{
    private static Set<LibraryConfiguration> librariesConfiguration;
    private static Set<String> librariesConfigurationEnumerationClassPaths;

    static
    {
        LibrariesConfigurationMapper.haveCoreLibrariesNotBeenRegistered = true;
        librariesConfiguration = new CopyOnWriteArraySet<LibraryConfiguration>();
        librariesConfigurationEnumerationClassPaths = new CopyOnWriteArraySet<String>();
    }


    public static Set<LibraryConfiguration> getLibrariesConfiguration()
    {
        return librariesConfiguration;
    }
    
    
    public static Set<String> getLibrariesConfigurationEnumerationClassPaths()
    {
        return librariesConfigurationEnumerationClassPaths;
    }
    
    
    public static synchronized void registerLibraryConfigurationEnumerationClassPath(String libraryConfigurationEnumerationClassPath)
    {
        getLibrariesConfigurationEnumerationClassPaths().add(libraryConfigurationEnumerationClassPath);
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