package annotations.services.registry.impl;

import java.util.stream.Stream;
import annotations.OrionAnnotation;
import annotations.services.AnnotationServiceObject;
import annotations.services.registry.AnnotationsRegistrationService;
import annotations.services.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
import annotations.services.registry.impl.tasks.IsAnnotationRegisteredTask;
import annotations.services.registry.impl.tasks.RegisterAnnotationTask;
import annotations.services.registry.impl.tasks.RegisterLibrariesAnnotationsTask;
import annotations.services.registry.impl.tasks.RegisterLibraryAnnotationsTask;
import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl extends AnnotationServiceObject implements AnnotationsRegistrationService
{
    @Override
    public void registerLibrariesAnnotations()
    {
        Stream<LibraryConfiguration> notNullLibrariesConfigurationStream = new FilterNotNullLibrariesConfigurationTask().run(LibrariesConfiguration.getLibrariesConfiguration());
        new RegisterLibrariesAnnotationsTask().run(notNullLibrariesConfigurationStream);
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
}