package configuration.classpath.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.LibrariesConfiguration;
import configuration.registry.PropertiesRegistrationService;
import configuration.registry.impl.PropertiesRegistrationServiceImpl;

public class LoadLibrariesPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run()
    {
        PropertiesRegistrationService propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
        LibrariesConfiguration.getLibrariesConfiguration()
            .stream()
            .filter(libraryConfiguration -> libraryConfiguration.getConfigurationFilePath() != null)
            .filter(libraryConfiguration -> propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration.getLibraryClassPath()))
            .forEach(libraryConfiguration -> {
                new LoadLibraryPropertiesTask().run(libraryConfiguration);
                new PropertiesRegistrationServiceImpl().setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
            });
    }
}