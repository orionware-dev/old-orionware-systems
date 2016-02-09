package core.annotations.registry;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.RegisteredAnnotation;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.loader.AnnotationsLoaderServiceImpl;
import core.annotations.registry.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.registry.tasks.FilterNotNullLibraryConfigurationsTask;
import core.annotations.registry.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.registry.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.annotations.registry.tasks.RegisterAnnotationTask;
import core.annotations.registry.tasks.RegisterLibrariesAnnotationsTask;
import core.annotations.registry.tasks.RegisterLibraryAnnotationsTask;
import core.annotations.registry.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private FilterNotNullLibraryConfigurationsTask filterNotNullLibraryConfigurationsTask = new FilterNotNullLibraryConfigurationsTask();
    private FilterAnnotationsNotBeenRegisteredForLibraryTask filterAnnotationsNotBeenRegisteredForLibraryTask = new FilterAnnotationsNotBeenRegisteredForLibraryTask();
    private RegisterLibrariesAnnotationsTask registerLibrariesAnnotationsTask = new RegisterLibrariesAnnotationsTask();
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
    private RegisterAnnotationTask registerAnnotationTask = new RegisterAnnotationTask();
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    private AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    
    
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        Stream<LibraryConfiguration> notNullLibraryConfigurations = filterNotNullLibraryConfigurationsTask.run(librariesConfiguration);
        notNullLibraryConfigurations = filterAnnotationsNotBeenRegisteredForLibraryTask.run(this, notNullLibraryConfigurations);
        registerLibrariesAnnotationsTask.run(this, annotationsLoaderService, notNullLibraryConfigurations);
    }
    
    
    @Override
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration)
    {
        loadLibraryAnnotationsDefinitionsTask.run(annotationsLoaderService, libraryConfiguration);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationTask.run(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryTask.run(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryTask.run(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsTask.run(this, annotationsLoaderService, libraryConfiguration);
    }
}