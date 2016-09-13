package annotations.registry;

import annotations.AnnotationService;
import annotations.OrionAnnotation;
import configuration.LibraryConfiguration;

public interface AnnotationsRegistrationService extends AnnotationService
{
    public void registerLibrariesAnnotations();


    public void registerAnnotation(OrionAnnotation registeredAnnotation);


    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
}