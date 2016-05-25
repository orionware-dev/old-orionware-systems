package core.annotations.facades.registration;

import java.util.Set;
import core.annotations.OrionAnnotation;
import core.configuration.LibraryConfiguration;
import core.services.OrionFacade;

public interface AnnotationsRegistrationFacade extends OrionFacade
{
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration);
    
    
    public void registerAnnotation(OrionAnnotation registeredAnnotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}