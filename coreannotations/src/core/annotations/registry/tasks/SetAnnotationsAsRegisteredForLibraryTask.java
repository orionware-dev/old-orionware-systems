package core.annotations.registry.tasks;

import core.annotations.AnnotationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetAnnotationsAsRegisteredForLibraryTask implements AnnotationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}