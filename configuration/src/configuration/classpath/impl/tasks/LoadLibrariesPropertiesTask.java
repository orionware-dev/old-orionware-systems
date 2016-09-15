package configuration.classpath.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;
import configuration.registry.PropertiesRegistrationService;
import configuration.registry.impl.PropertiesRegistrationServiceImpl;

public class LoadLibrariesPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run()
    {
        PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        
        for(LibraryConfiguration libraryConfiguration : LibrariesConfiguration.getLibrariesConfiguration())
        {
            if(libraryConfiguration != null
                   && propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryClassPath())
                   && libraryConfiguration.getConfigurationFilePath() != null)
            {
                LoadLibraryPropertiesTask.run(libraryConfiguration);
                propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryClassPath());
            }
        }
    }
}