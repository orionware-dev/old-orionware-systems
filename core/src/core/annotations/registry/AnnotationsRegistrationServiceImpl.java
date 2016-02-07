package core.annotations.registry;

import core.annotations.registry.haveannotationsbeenregisteredforlibrary.HaveAnnotationsBeenRegisteredForLibraryHelper;
import core.annotations.registry.loadlibraryannotationsdefinitions.LoadLibraryAnnotationsDefinitionsHelper;
import core.annotations.registry.registerlibraryannotations.RegisterLibraryAnnotationsHelper;
import core.annotations.registry.setannotationsasregisteredforlibrary.SetAnnotationsAsRegisteredForLibraryHelper;
import core.configuration.LibraryConfiguration;

public class AnnotationsRegistrationServiceImpl implements AnnotationsRegistrationService
{
    private HaveAnnotationsBeenRegisteredForLibraryHelper haveAnnotationsBeenRegisteredForLibraryHelper = new HaveAnnotationsBeenRegisteredForLibraryHelper();
    private SetAnnotationsAsRegisteredForLibraryHelper setAnnotationsAsRegisteredForLibraryHelper = new SetAnnotationsAsRegisteredForLibraryHelper();
    private RegisterLibraryAnnotationsHelper registerLibraryAnnotationsHelper = new RegisterLibraryAnnotationsHelper();
    private LoadLibraryAnnotationsDefinitionsHelper loadLibraryAnnotationsDefinitionsHelper = new LoadLibraryAnnotationsDefinitionsHelper();
    
    
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
        registerLibraryAnnotationsHelper.run(libraryConfiguration);
    }


    @Override
    public void loadLibraryAnnotationsDefinitions(LibraryConfiguration libraryConfiguration)
    {
        loadLibraryAnnotationsDefinitionsHelper.run(libraryConfiguration);
    }
}