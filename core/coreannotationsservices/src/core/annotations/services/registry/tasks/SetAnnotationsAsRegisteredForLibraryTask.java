package core.annotations.services.registry.tasks;

import core.OrionSimpleObject;
import core.annotations.AnnotationObject;
import core.annotations.AnnotationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetAnnotationsAsRegisteredForLibraryTask extends AnnotationObject implements AnnotationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}