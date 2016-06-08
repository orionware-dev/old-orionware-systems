package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class HaveAnnotationsBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public static boolean run(String libraryClassPath)
    {
        if(thisLibraryAnnotationsHaveBeenRegistered(libraryClassPath))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath);
        }
        else
        {
            return false;
        }
    }
    
    
    public static boolean run(LibraryConfiguration libraryConfiguration)
    {
        return run(libraryConfiguration.getLibraryClassPath());
    }
    
    
    private static boolean thisLibraryAnnotationsHaveBeenRegistered(String libraryClassPath)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryClassPath) != null;
    }
}