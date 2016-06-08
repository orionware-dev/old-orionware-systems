package core.annotations.services.registry.impl.tasks;

import core.annotations.AnnotationTask;
import core.annotations.services.AnnotationServiceObject;
import core.configuration.LibrariesConfigurationMapper;
import core.configuration.LibraryConfiguration;

public class SetAnnotationsAsRegisteredForLibraryTask extends AnnotationServiceObject implements AnnotationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
    
    
    public void run(LibraryConfiguration libraryConfiguration)
    {
        run(libraryConfiguration.getLibraryName());
    }
}