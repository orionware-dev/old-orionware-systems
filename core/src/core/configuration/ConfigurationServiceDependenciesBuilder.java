package core.configuration;

import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibrariesPropertiesTask;
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
        object.setLoadLibrariesPropertiesTask(new LoadLibrariesPropertiesTask());
    }
}