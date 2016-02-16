package core.annotations.services.registry.tasks;

import core.OrionSimpleObject;
import core.annotations.AnnotationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetAnnotationsAsRegisteredForLibraryTask extends OrionSimpleObject implements AnnotationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}