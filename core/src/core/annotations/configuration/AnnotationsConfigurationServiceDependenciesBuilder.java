package core.annotations.configuration;

import java.util.HashSet;
import core.annotations.AnnotationsServiceImpl;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;

public class AnnotationsConfigurationServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsConfigurationServiceImpl object)
    {
        object.setFileSystemService(new FileSystemServiceImpl());
        object.setLoadLibrariesAnnotationsTask(new LoadLibrariesAnnotationsTask());
        object.setGetClasspathRootPathTask(new GetClasspathRootPathTask());
        object.setGetAnnotationsFileStreamTask(new GetAnnotationsFileStreamTask());
    }
}