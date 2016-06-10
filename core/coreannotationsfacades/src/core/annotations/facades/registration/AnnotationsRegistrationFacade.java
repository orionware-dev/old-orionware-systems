package core.annotations.facades.registration;

import core.annotations.AnnotationFacade;
import core.annotations.OrionAnnotation;
import core.configuration.LibraryConfiguration;

public interface AnnotationsRegistrationFacade extends AnnotationFacade
{
    public void registerLibrariesAnnotations();
    
    
    public void registerAnnotation(OrionAnnotation registeredAnnotation);
    
    
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}