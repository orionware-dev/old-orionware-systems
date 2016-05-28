package core.annotations.services.registry.impl;

import java.util.Set;
import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.tasks.FilterAnnotationsNotBeenRegisteredForLibraryTask;
import core.annotations.services.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
import core.annotations.services.registry.impl.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import core.annotations.services.registry.impl.tasks.RegisterAnnotationTask;
import core.annotations.services.registry.impl.tasks.RegisterLibrariesAnnotationsTask;
import core.annotations.services.registry.impl.tasks.RegisterLibraryAnnotationsTask;
import core.annotations.services.registry.impl.tasks.SetAnnotationsAsRegisteredForLibraryTask;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl extends AnnotationServiceObject implements AnnotationsRegistrationService
{
    private FilterNotNullLibrariesConfigurationTask filterNotNullLibrariesConfigurationTask;
    private FilterAnnotationsNotBeenRegisteredForLibraryTask filterAnnotationsNotBeenRegisteredForLibraryTask;
    private RegisterLibrariesAnnotationsTask registerLibrariesAnnotationsTask;
    private RegisterAnnotationTask registerAnnotationTask;
    private RegisterLibraryAnnotationsTask registerLibraryAnnotationsTask;
    private HaveAnnotationsBeenRegisteredForLibraryTask haveAnnotationsBeenRegisteredForLibraryTask;
    private SetAnnotationsAsRegisteredForLibraryTask setAnnotationsAsRegisteredForLibraryTask;
    
    
    public AnnotationsRegistrationServiceImpl()
    {
        this.filterNotNullLibrariesConfigurationTask = new FilterNotNullLibrariesConfigurationTask();
        this.filterAnnotationsNotBeenRegisteredForLibraryTask = new FilterAnnotationsNotBeenRegisteredForLibraryTask();
        this.registerLibrariesAnnotationsTask = new RegisterLibrariesAnnotationsTask();
        this.registerAnnotationTask = new RegisterAnnotationTask();
        this.registerLibraryAnnotationsTask = new RegisterLibraryAnnotationsTask();
        this.haveAnnotationsBeenRegisteredForLibraryTask = new HaveAnnotationsBeenRegisteredForLibraryTask();
        this.setAnnotationsAsRegisteredForLibraryTask = new SetAnnotationsAsRegisteredForLibraryTask();
    }
    
    
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        Stream<LibraryConfiguration> notNullLibrariesConfigurationStream = filterNotNullLibrariesConfigurationTask.run(librariesConfiguration);
        notNullLibrariesConfigurationStream = filterAnnotationsNotBeenRegisteredForLibraryTask.run(notNullLibrariesConfigurationStream);
        registerLibrariesAnnotationsTask.run(notNullLibrariesConfigurationStream);
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
        registerLibraryAnnotationsTask.run(libraryConfiguration);
    }
}