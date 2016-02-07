package core.annotations.registry;

import java.util.Set;
import core.annotations.RegisteredAnnotation;
import core.annotations.loader.AnnotationsLoaderService;
import core.annotations.loader.AnnotationsLoaderServiceImpl;
import core.annotations.registry.annotationsdefinitions.RegisterLibraryAnnotationsDefinitionsCoordinator;
import core.annotations.registry.haveannotationsbeenregisteredforlibrary.HaveAnnotationsBeenRegisteredForLibraryCoordinator;
import core.annotations.registry.librariesannotations.RegisterLibrariesAnnotationsCoordinator;
import core.annotations.registry.registerannotation.RegisterAnnotationCoordinator;
import core.annotations.registry.registerlibraryannotations.RegisterLibraryAnnotationsCoordinator;
import core.annotations.registry.setannotationsasregisteredforlibrary.SetAnnotationsAsRegisteredForLibraryCoordinator;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private RegisterLibrariesAnnotationsCoordinator registerLibrariesAnnotationsCoordinator = new RegisterLibrariesAnnotationsCoordinator();
    private RegisterLibraryAnnotationsDefinitionsCoordinator registerLibraryAnnotationsDefinitionsCoordinator = new RegisterLibraryAnnotationsDefinitionsCoordinator();
    private RegisterAnnotationCoordinator registerAnnotationCoordinator = new RegisterAnnotationCoordinator();
    private HaveAnnotationsBeenRegisteredForLibraryCoordinator haveAnnotationsBeenRegisteredForLibraryCoordinator = new HaveAnnotationsBeenRegisteredForLibraryCoordinator();
    private SetAnnotationsAsRegisteredForLibraryCoordinator setAnnotationsAsRegisteredForLibraryCoordinator = new SetAnnotationsAsRegisteredForLibraryCoordinator();
    private RegisterLibraryAnnotationsCoordinator registerLibraryAnnotationsCoordinator = new RegisterLibraryAnnotationsCoordinator();
    private AnnotationsLoaderService annotationsLoaderService = new AnnotationsLoaderServiceImpl();
    
    
    @Override
    public void registerLibrariesAnnotations(Set<LibraryConfiguration> librariesConfiguration)
    {
        registerLibrariesAnnotationsCoordinator.run(this, annotationsLoaderService, librariesConfiguration);
    }
    
    
    @Override
    public void registerLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsDefinitionsCoordinator.run(annotationsLoaderService, libraryConfiguration);
    }
    
    
    @Override
    public void registerAnnotation(RegisteredAnnotation registeredAnnotation)
    {
        registerAnnotationCoordinator.run(registeredAnnotation);
    }
    
    
    @Override
    public boolean haveAnnotationsBeenRegisteredForLibrary(String libraryName)
    {
        return haveAnnotationsBeenRegisteredForLibraryCoordinator.run(libraryName);
    }

    
    @Override
    public boolean haveAnnotationsNotBeenRegisteredForLibrary(String libraryName)
    {
        return !haveAnnotationsBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setAnnotationsAsRegisteredForLibrary(String libraryName)
    {
        setAnnotationsAsRegisteredForLibraryCoordinator.run(libraryName);
    }


    @Override
    public void registerLibraryAnnotations(LibraryConfiguration libraryConfiguration)
    {
        registerLibraryAnnotationsCoordinator.run(this, annotationsLoaderService, libraryConfiguration);
    }
}