package core.annotations.registry;

import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.loader.AnnotationsLoaderServiceImpl;
import core.annotations.registry.annotationsdefinitions.RegisterLibraryAnnotationsDefinitionsHelper;
import core.annotations.registry.haveannotationsbeenregisteredforlibrary.HaveAnnotationsBeenRegisteredForLibraryHelper;
import core.annotations.registry.librariesannotations.RegisterLibrariesAnnotationsHelper;
import core.annotations.registry.registerannotation.RegisterAnnotationHelper;
import core.annotations.registry.registerlibraryannotations.RegisterLibraryAnnotationsHelper;
import core.annotations.registry.setannotationsasregisteredforlibrary.SetAnnotationsAsRegisteredForLibraryHelper;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private RegisterLibrariesAnnotationsHelper registerLibrariesAnnotationsHelper = new RegisterLibrariesAnnotationsHelper();
    private RegisterLibraryAnnotationsDefinitionsHelper registerLibraryAnnotationsDefinitionsHelper = new RegisterLibraryAnnotationsDefinitionsHelper();
    private RegisterAnnotationHelper registerAnnotationHelper = new RegisterAnnotationHelper();
    private HaveAnnotationsBeenRegisteredForLibraryHelper haveAnnotationsBeenRegisteredForLibraryHelper = new HaveAnnotationsBeenRegisteredForLibraryHelper();
    private SetAnnotationsAsRegisteredForLibraryHelper setAnnotationsAsRegisteredForLibraryHelper = new SetAnnotationsAsRegisteredForLibraryHelper();
    private RegisterLibraryAnnotationsHelper registerLibraryAnnotationsHelper = new RegisterLibraryAnnotationsHelper();
    private AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    
    
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        registerLibrariesAnnotationsHelper.run(this, annotationsLoaderService, librariesConfiguration);
    }
    
    
    @Override
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsDefinitionsHelper.run(annotationsLoaderService, libraryConfiguration);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationHelper.run(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryHelper.run(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryHelper.run(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsHelper.run(this, annotationsLoaderService, libraryConfiguration);
    }
}