package core.annotations.registry.tasks;

import core.annotations.OrionAnnotationTask;
import core.configuration.LibrariesConfigurationMapper;

public class SetAnnotationsAsRegisteredForLibraryTask implements OrionAnnotationTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}