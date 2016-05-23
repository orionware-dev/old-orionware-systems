package core.configuration.registry.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.LibraryConfiguration;
import core.configuration.OrionConfigurationTask;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.PropertiesRegistrationService;

public class RegisterLibraryPropertiesTask extends ConfigurationObject implements OrionConfigurationTask
{
    public void run(ConfigurationService configurationService, LoadLibraryPropertiesTask loadLibraryPropertiesTask, PropertiesRegistrationService propertiesRegistrationService, LibraryConfiguration libraryConfiguration)
    {
        loadLibraryPropertiesTask.run(configurationService, libraryConfiguration);
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
}