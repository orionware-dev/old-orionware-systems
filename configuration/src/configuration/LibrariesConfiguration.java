package configuration;

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
        LibrariesConfigurationMapper.coreLibrariesHaveNotBeenRegistered = true;
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
        if(LibrariesConfigurationMapper.coreLibrariesHaveNotBeenRegistered)
        {
            getLibrariesConfiguration().add(libraryConfiguration);

            if(libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
            {
                LibrariesConfigurationMapper.coreLibrariesHaveNotBeenRegistered = false;
            }
        }
        else if(!libraryConfiguration.getLibraryClassPath().equals(CoreConfigurationConfigurationEnumeration.LIBRARY_CLASS_PATH.get()))
        {
            getLibrariesConfiguration().add(libraryConfiguration);
        }

        LibrariesConfigurationMapper.LIBRARIES_AND_IF_CONFIGURATION_HAS_BEEN_REGISTERED_MAPPER.put(libraryConfiguration.getLibraryClassPath(), true);
    }
}