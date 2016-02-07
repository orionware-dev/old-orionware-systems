package core.annotations.registry;

import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface AnnotationsRegistrationService extends OrionService
{
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration);
    
    
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}