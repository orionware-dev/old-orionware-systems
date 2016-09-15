package annotations.registry.impl;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistrationService;
import annotations.registry.impl.tasks.FilterLibrariesConfigurationsHavingAnnotationsTask;
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
        RegisterLibrariesAnnotationsTask.run();
    }


    @Override
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        RegisterAnnotationTask.run(registeredAnnotation);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        new RegisterLibraryAnnotationsTask().run(libraryConfiguration);
    }


    @Override
    public boolean isAnnotationRegistered(OrionAnnotation annotation)
    {
        return IsAnnotationRegisteredTask.run(annotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return HaveAnnotationsBeenRegisteredForLibraryTask.run(libraryConfiguration);
    }


    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryClassPath)
    {
        return HaveAnnotationsBeenRegisteredForLibraryTask.run(libraryClassPath);
    }


    @Override
    public List<LibraryConfiguration> filterLibrariesConfigurationsHavingAnnotations(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterLibrariesConfigurationsHavingAnnotationsTask.run(librariesConfiguration);
    }
    
    
    @Override
    public List<LibraryConfiguration> filterRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterRegisteredLibrariesConfigurationTask.run(librariesConfiguration);
    }


    @Override
    public List<LibraryConfiguration> filterNotRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration)
    {
        return FilterNotRegisteredLibrariesConfigurationTask.run(librariesConfiguration);
    }
}