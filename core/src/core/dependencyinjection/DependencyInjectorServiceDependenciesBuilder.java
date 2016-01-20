package core.dependencyinjection;

import java.util.HashSet;
import core.annotations.AnnotationsServiceImpl;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.configuration.tasks.GetClasspathRootTask;
import core.configuration.tasks.GetConfigurationPathTask;
import core.configuration.tasks.LoadLibrariesPropertiesTask;
import core.dependencyinjection.tasks.ProcessDependenciesTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;
import core.reflection.ReflectionServiceImpl;

public class DependencyInjectorServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(DependencyInjectorServiceImpl object)
    {
        object.setProcessDependenciesTask(new ProcessDependenciesTask());
        object.setReflectionService(new ReflectionServiceImpl());
    }
}