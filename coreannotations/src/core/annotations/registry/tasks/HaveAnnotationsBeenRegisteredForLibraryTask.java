package core.annotations.registry.tasks;

import core.annotations.OrionAnnotationTask;
import core.configuration.LibrariesConfigurationMapper;

public class HaveAnnotationsBeenRegisteredForLibraryTask implements OrionAnnotationTask
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