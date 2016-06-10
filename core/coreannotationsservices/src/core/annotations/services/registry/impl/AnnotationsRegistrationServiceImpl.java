package core.annotations.services.registry.impl;

import java.util.stream.Stream;
import core.annotations.OrionAnnotation;
import core.annotations.services.AnnotationServiceObject;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.tasks.FilterNotNullLibrariesConfigurationTask;
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
        Stream<LibraryConfiguration> notNullLibrariesConfigurationStream = FilterNotNullLibrariesConfigurationTask.run(LibrariesConfiguration.getLibrariesConfigurationSet());
        RegisterLibrariesAnnotationsTask.run(notNullLibrariesConfigurationStream);
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
}