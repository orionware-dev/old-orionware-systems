package core.libraries;

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
import core.filesystem.tasks.CloseResourceTask;
import core.filesystem.tasks.ConvertFileToStringTask;
import core.filesystem.tasks.EmptyDirectoryTask;
import core.filesystem.tasks.GetFileStreamTask;
import core.filesystem.tasks.GetReaderFromFileTask;
import core.filesystem.tasks.GetWriterForFileTask;
import core.filesystem.tasks.SaveStringToFileTask;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;
import core.libraries.tasks.IsCoreLibraryTask;
import core.reflection.ReflectionServiceImpl;

public class LibraryServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(LibraryServiceImpl object)
    {
        object.setIsCoreLibraryTask(new IsCoreLibraryTask());
    }
}