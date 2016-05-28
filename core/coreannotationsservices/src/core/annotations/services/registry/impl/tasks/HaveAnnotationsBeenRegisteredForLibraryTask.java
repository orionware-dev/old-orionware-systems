package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibrariesConfigurationMapper;

public class HaveAnnotationsBeenRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public boolean run(String libraryName)
    {
        if(thisLibraryAnnotationsHaveBeenRegistered(libraryName))
        {
            return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName);
        }
        else
        {
            return false;
        }
    }
    
    
    private boolean thisLibraryAnnotationsHaveBeenRegistered(String libraryName)
    {
        return LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.get(libraryName) != null;
    }
}