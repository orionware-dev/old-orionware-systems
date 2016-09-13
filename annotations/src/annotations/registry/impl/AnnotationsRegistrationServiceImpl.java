package annotations.registry.impl;

import annotations.AnnotationServiceObject;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistrationService;
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
}