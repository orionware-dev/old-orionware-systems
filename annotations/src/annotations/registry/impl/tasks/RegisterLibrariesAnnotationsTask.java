package annotations.registry.impl.tasks;

import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.AnnotationTask;
import configuration.LibrariesConfiguration;
import configuration.LibrariesConfigurationMapper;
import configuration.LibraryConfiguration;

public class RegisterLibrariesAnnotationsTask extends AnnotationServiceObject implements AnnotationTask
{
    public static void run()
    {
        List<LibraryConfiguration> notRegisteredLibrariesConfiguration = FilterNotRegisteredLibrariesConfigurationTask.run(LibrariesConfiguration.getLibrariesConfiguration());
        RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        
        for(LibraryConfiguration libraryConfiguration : notRegisteredLibrariesConfiguration)
        {
            registerLibraryAnnotationsTask.run(libraryConfiguration);
            LibrariesConfigurationMapper.LIBRARIES_AND_IF_ANNOTATIONS_HAVE_BEEN_REGISTERED_MAPPER.put(libraryConfiguration.getLibraryClassPath(), true);
        }
    }
}