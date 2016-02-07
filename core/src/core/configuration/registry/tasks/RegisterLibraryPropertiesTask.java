package core.configuration.registry.tasks;

import core.configuration.ConfigurationService;
import core.configuration.LibraryConfiguration;
import core.configuration.registry.PropertiesRegistrationService;
import core.configuration.tasks.GetCoreClasspathRootPathTask;
import core.configuration.tasks.LoadLibraryPropertiesTask;
import core.services.OrionTask;

public class RegisterLibraryPropertiesTask implements OrionTask
{
    public void run(ConfigurationService configurationService, GetCoreClasspathRootPathTask getCoreClasspathRootPathTask, LoadLibraryPropertiesTask loadLibraryPropertiesTask, PropertiesRegistrationService propertiesRegistrationService, LibraryConfiguration libraryConfiguration)
    {
        loadLibraryPropertiesTask.run(getCoreClasspathRootPathTask, configurationService, libraryConfiguration);
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration.getLibraryName());
    }
}