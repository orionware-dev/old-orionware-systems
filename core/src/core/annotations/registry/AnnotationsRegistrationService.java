package core.annotations.registry;

import core.configuration.LibraryConfiguration;
import core.services.OrionService;

public interface AnnotationsRegistrationService extends OrionService
{
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setAnnotationsAsRegisteredForLibrary(String libraryName);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
    
    
    public void loadLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration);
}