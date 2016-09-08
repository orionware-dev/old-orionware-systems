package core.annotations.services.registry.impl;

import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
import core.annotations.services.registry.impl.tasks.IsAnnotationRegisteredTask;
import core.annotations.services.registry.impl.tasks.RegisterAnnotationTask;
import core.annotations.services.registry.impl.tasks.RegisterLibrariesAnnotationsTask;
import core.annotations.services.registry.impl.tasks.RegisterLibraryAnnotationsTask;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;

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