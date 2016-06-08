package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class SetAnnotationsAsRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public static void run(String libraryClassPath)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryClassPath, true);
    }
    
    
    public static void run(LibraryConfiguration libraryConfiguration)
    {
        run(libraryConfiguration.getLibraryClassPath());
    }
}