package core.annotations.registry;

import java.util.Set;
import core.annotations.OrionAnnotation;
import core.annotations.OrionAnnotationService;
import core.configuration.LibraryConfiguration;

public interface AnnotationsRegistrationService extends OrionAnnotationService
{
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration);
    
    
    public void registerAnnotation(OrionAnnotation registeredAnnotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}