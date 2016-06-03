package core.configuration;

import java.util.HashSet;
import java.util.Set;
import core.abstraction.OrionConfiguration;

public class LibrariesConfiguration extends OrionConfiguration
{
    private static boolean haveCoreLibrariesNotBeenRegistered;
    private static Set<LibraryConfiguration> librariesConfigurationSet;
    
    
    static
    {
        haveCoreLibrariesNotBeenRegistered = true;
        librariesConfigurationSet = new HashSet<LibraryConfiguration>();
    }


    public static Set<LibraryConfiguration> getLibrariesConfigurationSet()
    {
        return librariesConfigurationSet;
    }
    
    
    public static void registerLibraryConfiguration(LibraryConfiguration libraryConfiguration)
    {
        if(haveCoreLibrariesNotBeenRegistered)
        {
            getLibrariesConfigurationSet().add(libraryConfiguration);
            
            if(libraryConfiguration.getLibraryName().equals(CoreConfigurationEnum.LIBRARY_NAME))
            {
                haveCoreLibrariesNotBeenRegistered = false;
            }
        }
        else if(!libraryConfiguration.getLibraryName().equals(CoreConfigurationEnum.LIBRARY_NAME))
        {
            getLibrariesConfigurationSet().add(libraryConfiguration);
        }
    }
}