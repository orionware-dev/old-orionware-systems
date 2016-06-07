package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.services.classpath.ConfigurationClasspathService;
import core.configuration.services.classpath.impl.tasks.LoadLibraryPropertiesTask;
import core.configuration.services.registry.PropertiesRegistrationService;

public class RegisterLibraryPropertiesTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(ConfigurationClasspathService configurationClasspathService, LoadLibraryPropertiesTask loadLibraryPropertiesTask, PropertiesRegistrationService propertiesRegistrationService, LibraryConfiguration libraryConfiguration)
    {
        loadLibraryPropertiesTask.run(configurationClasspathService, libraryConfiguration);
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
}