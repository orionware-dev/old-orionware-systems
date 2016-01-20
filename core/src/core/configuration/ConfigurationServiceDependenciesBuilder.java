package core.configuration;

import java.util.HashSet;
import core.annotations.AnnotationsServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibrariesPropertiesTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;

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