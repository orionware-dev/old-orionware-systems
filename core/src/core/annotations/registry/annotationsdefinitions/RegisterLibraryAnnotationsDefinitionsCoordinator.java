package core.annotations.registry.annotationsdefinitions;

import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.registry.annotationsdefinitions.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.configuration.LibraryConfiguration;
import core.services.OrionServiceCoordinator;

public class RegisterLibraryAnnotationsDefinitionsCoordinator implements OrionServiceCoordinator
{
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
    
    
    public void run(AnnotationsLoaderService annotationsLoaderService, LibraryConfiguration libraryConfiguration)
    {
        loadLibraryAnnotationsDefinitionsTask.run(annotationsLoaderService, libraryConfiguration);
    }
}