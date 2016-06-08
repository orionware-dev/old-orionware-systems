package core.annotations.services.registry;

import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;
import core.configuration.LibraryConfiguration;

public interface AnnotationsRegistrationService extends AnnotationService
{
    public void registerLibrariesAnnotations();
    
    
    public void registerAnnotation(OrionAnnotation registeredAnnotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName);
    
    
    public void setAnnotationsAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}