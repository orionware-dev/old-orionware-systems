package annotations.registry.impl;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistrationService;
import annotations.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
import annotations.registry.impl.tasks.FilterNotRegisteredLibrariesConfigurationTask;
import annotations.registry.impl.tasks.FilterRegisteredLibrariesConfigurationTask;
import annotations.registry.impl.tasks.HaveAnnotationsBeenRegisteredForLibraryTask;
import annotations.registry.impl.tasks.IsAnnotationRegisteredTask;
import annotations.registry.impl.tasks.RegisterAnnotationTask;
import annotations.registry.impl.tasks.RegisterLibrariesAnnotationsTask;
import annotations.registry.impl.tasks.RegisterLibraryAnnotationsTask;
import configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl extends AnnotationServiceObject implements AnnotationsRegistrationService
{
    @Override
    public void registerLibrariesAnnotations()
    {
        new RegisterLibrariesAnnotationsTask().run();
    }


    @Override
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        new RegisterAnnotationTask().run(registeredAnnotation);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        new RegisterLibraryAnnotationsTask().run(libraryConfiguration);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return new IsAnnotationRegisteredTask().run(annotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return new HaveAnnotationsBeenRegisteredForLibraryTask().run(libraryConfiguration);
    }


    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryClassPath)
    {
        return new HaveAnnotationsBeenRegisteredForLibraryTask().run(libraryClassPath);
    }


    @Override
    public List<LibraryConfiguration> filterNotNullLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return new FilterNotNullLibrariesConfigurationTask().run(librariesConfiguration);
    }
    
    
    @Override
    public List<LibraryConfiguration> filterRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return new FilterRegisteredLibrariesConfigurationTask().run(librariesConfiguration);
    }


    @Override
    public List<LibraryConfiguration> filterNotRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return new FilterNotRegisteredLibrariesConfigurationTask().run(librariesConfiguration);
    }
}