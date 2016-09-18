package annotations.registry;

import annotations.AnnotationService;
import annotations.AnnotationType;
import annotations.OrionAnnotation;
import configuration.LibraryConfiguration;

public interface AnnotationsRegistryService extends AnnotationService
{
    public void registerLibrariesAnnotations();


    public void registerAnnotation(OrionAnnotation registeredAnnotation);


    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryClassPath);
    
    
    public void addAnnotationTypeForObject(OrionAnnotation annotation, AnnotationType annotationType);
}