package core.annotations.services.registry;

import core.annotations.AnnotationService;
import core.annotations.OrionAnnotation;
import core.configuration.LibraryConfiguration;

public interface AnnotationsRegistrationService extends AnnotationService
{
    public void registerLibrariesAnnotations();


    public void registerAnnotation(OrionAnnotation registeredAnnotation);


    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration);
}