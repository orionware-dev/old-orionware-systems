package core.annotations.facades.registration.impl;

import core.annotations.OrionAnnotation;
import core.annotations.facades.AnnotationFacadeObject;
import core.annotations.facades.registration.AnnotationsRegistrationFacade;
import core.annotations.services.registry.AnnotationsRegistrationService;
import core.annotations.services.registry.impl.AnnotationsRegistrationServiceImpl;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationFacadeImpl extends AnnotationFacadeObject implements AnnotationsRegistrationFacade
{
    private AnnotationsRegistrationService annotationsRegistrationService;
    
    
    public AnnotationsRegistrationFacadeImpl()
    {
        this.annotationsRegistrationService = new AnnotationsRegistrationServiceImpl();
    }
    
    
    @Override
    public void registerLibrariesAnnotations()
    {
        annotationsRegistrationService.registerLibrariesAnnotations();
    }
    
    
    @Override
    public void registerAnnotation(OrionAnnotation registeredAnnotation)
    {
        annotationsRegistrationService.registerAnnotation(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return annotationsRegistrationService.haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        annotationsRegistrationService.setAnnotationsAsRegisteredForLibrary(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        annotationsRegistrationService.registerLibraryAnnotations(libraryConfiguration);
    }
}