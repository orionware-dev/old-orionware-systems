package core.configuration.registry.tasks;

import core.configuration.OrionConfigurationTask;
import core.configuration.LibraryConfiguration;
import core.configuration.classpath.ConfigurationService;
import core.configuration.classpath.tasks.GetCoreClasspathRootPathTask;
import core.configuration.classpath.tasks.LoadLibraryPropertiesTask;
import core.configuration.registry.PropertiesRegistrationService;

public class RegisterLibraryPropertiesTask implements OrionConfigurationTask
{
    public void run(ConfigurationService configurationService, GetCoreClasspathRootPathTask getCoreClasspathRootPathTask, LoadLibraryPropertiesTask loadLibraryPropertiesTask, PropertiesRegistrationService propertiesRegistrationService, LibraryConfiguration libraryConfiguration)
    {
        loadLibraryPropertiesTask.run(getCoreClasspathRootPathTask, configurationService, libraryConfiguration);
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
}