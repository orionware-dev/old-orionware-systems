package configuration.registry.impl.tasks.libraries;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;
import configuration.registry.ConfigurationRegistryService;
import configuration.registry.impl.ConfigurationRegistryServiceImpl;

public class LoadLibrariesPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run()
    {
        ConfigurationRegistryService configurationRegistryService = new ConfigurationRegistryServiceImpl();
        
        for(LibraryConfiguration libraryConfiguration : LibrariesConfiguration.getLibrariesConfiguration())
        {
            if(libraryConfiguration != null
                   && configurationRegistryService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryClassPath())
                   && libraryConfiguration.getConfigurationFilePath() != null)
            {
                LoadLibraryPropertiesTask.run(libraryConfiguration);
                configurationRegistryService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryClassPath());
            }
        }
    }
}