package annotations.registry;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationService;
import annotations.OrionAnnotation;
import configuration.LibraryConfiguration;

public interface AnnotationsRegistrationService extends AnnotationService
{
    public void registerLibrariesAnnotations();


    public void registerAnnotation(OrionAnnotation registeredAnnotation);


    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
    
    
    public boolean isAnnotationRegistered(OrionAnnotation annotation);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration);
    
    
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryClassPath);
    
    
    public List<LibraryConfiguration> filterLibrariesConfigurationsHavingAnnotations(Collection<LibraryConfiguration> librariesConfiguration);
    
    
    public List<LibraryConfiguration> filterRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration);
    
    
    public List<LibraryConfiguration> filterNotRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration);
}