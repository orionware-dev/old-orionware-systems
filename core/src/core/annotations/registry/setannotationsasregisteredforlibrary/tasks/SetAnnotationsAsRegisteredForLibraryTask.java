package core.annotations.registry.setannotationsasregisteredforlibrary.tasks;

import core.configuration.LibrariesConfigurationMapper;
import core.services.OrionTask;

public class SetAnnotationsAsRegisteredForLibraryTask implements OrionTask
{
    public void run(String libraryName)
    {
        LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryName, true);
    }
}