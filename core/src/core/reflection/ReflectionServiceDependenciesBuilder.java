package core.reflection;

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
import core.reflection.tasks.CallConstructorTask;
import core.reflection.tasks.CallMethodTask;
import core.reflection.tasks.GetConstructorsArrayTask;
import core.reflection.tasks.GetMethodsArrayTask;
import core.reflection.tasks.InstantiateClassTask;
import core.reflection.tasks.LoadClassTask;
import core.reflection.tasks.MakeMethodAccessibleTask;

public class ReflectionServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(ReflectionServiceImpl object)
    {
        object.setGetMethodsArrayTask(new GetMethodsArrayTask());
        object.setGetConstructorsArrayTask(new GetConstructorsArrayTask());
        object.setMakeMethodAccessibleTask(new MakeMethodAccessibleTask());
        object.setCallMethodTask(new CallMethodTask());
        object.setCallConstructorTask(new CallConstructorTask());
        object.setLoadClassTask(new LoadClassTask());
        object.setInstantiateClassTask(new InstantiateClassTask());
    }
}