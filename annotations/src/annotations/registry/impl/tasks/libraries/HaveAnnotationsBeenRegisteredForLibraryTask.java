package annotations.registry.impl.tasks.libraries;

import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;

public class HaveAnnotationsBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public static boolean run(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER
                   .get(libraryClassPath) != null;
    }
    
    
    public static boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }
}