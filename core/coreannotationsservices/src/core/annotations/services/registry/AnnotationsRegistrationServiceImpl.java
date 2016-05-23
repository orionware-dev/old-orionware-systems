package core.annotations.services.registry;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.AnnotationObject;
import core.annotations.OrionAnnotation;
import core.annotations.services.loader.AnnotationsLoaderService;
import core.annotations.services.loader.AnnotationsLoaderServiceImpl;
import core.annotations.services.registry.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.services.registry.tasks.FilterNotNullLibraryConfigurationsTask;
import core.annotations.services.registry.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.services.registry.tasks.LoadLibraryAnnotationsDefinitionsTask;
import core.annotations.services.registry.tasks.RegisterAnnotationTask;
import core.annotations.services.registry.tasks.RegisterLibrariesAnnotationsTask;
import core.annotations.services.registry.tasks.RegisterLibraryAnnotationsTask;
import core.annotations.services.registry.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl extends AnnotationObject implements AnnotationsRegistrationService
{
    private FilterNotNullLibraryConfigurationsTask filterNotNullLibraryConfigurationsTask;
    private FilterAnnotationsNotBeenRegisteredForLibraryTask filterAnnotationsNotBeenRegisteredForLibraryTask;
    private RegisterLibrariesAnnotationsTask registerLibrariesAnnotationsTask;
    private LoadLibraryAnnotationsDefinitionsTask loadLibraryAnnotationsDefinitionsTask;
    private RegisterAnnotationTask registerAnnotationTask;
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask;
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask;
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask;
    private AnnotationsLoaderService annotationsLoaderService;
    
    
    public AnnotationsRegistrationServiceImpl()
    {
        filterNotNullLibraryConfigurationsTask = new FilterNotNullLibraryConfigurationsTask();
        filterAnnotationsNotBeenRegisteredForLibraryTask = new FilterAnnotationsNotBeenRegisteredForLibraryTask();
        registerLibrariesAnnotationsTask = new RegisterLibrariesAnnotationsTask();
        loadLibraryAnnotationsDefinitionsTask = new LoadLibraryAnnotationsDefinitionsTask();
        registerAnnotationTask = new RegisterAnnotationTask();
        registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
        annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    }
    
    
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
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
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