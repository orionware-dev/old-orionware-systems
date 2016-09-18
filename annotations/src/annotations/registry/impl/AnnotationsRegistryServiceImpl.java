package annotations.registry.impl;

import annotations.AnnotationServiceObject;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import annotations.registry.AnnotationsRegistryService;
import annotations.registry.impl.tasks.AddAnnotationTypeForObjectTask;
import annotations.registry.impl.tasks.IsAnnotationRegisteredTask;
import annotations.registry.impl.tasks.RegisterAnnotationTask;
import annotations.registry.impl.tasks.libraries.HaveAnnotationsBeenRegisteredForLibraryTask;
import annotations.registry.impl.tasks.libraries.RegisterLibrariesAnnotationsTask;
import annotations.registry.impl.tasks.libraries.RegisterLibraryAnnotationsTask;
import configuration.LibraryConfiguration;

public class AnnotationsRegistryServiceImpl extends AnnotationServiceObject implements AnnotationsRegistryService
{
    private AddAnnotationTypeForObjectTask addAnnotationTypeForObjectTask = new AddAnnotationTypeForObjectTask();
    
    
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
    public void addAnnotationTypeForObject(OrionAnnotation annotation, AnnotationType annotationType)
    {
        addAnnotationTypeForObjectTask.run(annotation, annotationType);
    }
}