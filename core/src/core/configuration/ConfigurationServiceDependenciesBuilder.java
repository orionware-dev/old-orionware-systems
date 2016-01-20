package core.configuration;

import core.configuration.registry.PropertiesRegistrationServiceImpl;
import core.configuration.registry.tasks.RegisterLibraryPropertiesTask;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibraryPropertiesTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;

public class ConfigurationServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(ConfigurationServiceImpl object)
    {
        object.setGetClasspathRootPathTask(new GetClasspathRootPathTask());
        object.setGetClasspathRootTask(new GetClasspathRootTask());
        object.setFileSystemService(new FileSystemServiceImpl());
        object.setGetConfigurationPathTask(new GetConfigurationPathTask());
        object.setPropertiesRegistrationService(new PropertiesRegistrationServiceImpl());
        object.setRegisterLibraryPropertiesTask(new RegisterLibraryPropertiesTask());
        object.setLoadLibraryPropertiesTask(new LoadLibraryPropertiesTask());
    }
}