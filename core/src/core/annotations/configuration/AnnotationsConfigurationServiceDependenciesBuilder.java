package core.annotations.configuration;

import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;

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