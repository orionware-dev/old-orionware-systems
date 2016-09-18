package annotations.filtering;

import java.util.Collection;
import java.util.List;
import annotations.AnnotationService;
import annotations.OrionAnnotation;
import configuration.LibraryConfiguration;

public interface AnnotationsFilteringService extends AnnotationService
{
    public List<OrionAnnotation> filterRegisteredAnnotationsFromObjectAnnotations(Collection<OrionAnnotation> allObjectAnnotations);
    
    
    public boolean doesObjectHaveRegisteredAnnotation(Collection<OrionAnnotation> allObjectAnnotations, OrionAnnotation registeredAnnotation);
    
    
    public List<LibraryConfiguration> filterLibrariesConfigurationsHavingAnnotations(Collection<LibraryConfiguration> librariesConfiguration);
    
    
    public List<LibraryConfiguration> filterRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration);
    
    
    public List<LibraryConfiguration> filterNotRegisteredLibrariesConfiguration(Collection<LibraryConfiguration> librariesConfiguration);
}