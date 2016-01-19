package core.annotations.processor;

import java.util.HashSet;
import core.annotations.AnnotationsServiceImpl;
import core.annotations.configuration.tasks.GetAnnotationsFileStreamTask;
import core.annotations.configuration.tasks.LoadLibrariesAnnotationsTask;
import core.annotations.processor.tasks.ApplyAnnotationsTask;
import core.annotations.processor.tasks.GatherAllObjectAnnotationsTask;
import core.configuration.ConfigurationServiceImpl;
import core.configuration.LibraryConfiguration;
import core.configuration.tasks.GetClasspathRootPathTask;
import core.filesystem.FileSystemServiceImpl;
import core.general.ObjectDependenciesBuilder;
import core.libraries.LibraryServiceImpl;
import core.reflection.ReflectionServiceImpl;

public class AnnotationsProcessorServiceDependenciesBuilder extends ObjectDependenciesBuilder
{
    public void injectDependencies(AnnotationsProcessorServiceImpl object)
    {
        object.setGatherAllObjectAnnotationsTask(new GatherAllObjectAnnotationsTask());
        object.setApplyAnnotationsTask(new ApplyAnnotationsTask());
        object.setReflectionService(new ReflectionServiceImpl());
    }
}