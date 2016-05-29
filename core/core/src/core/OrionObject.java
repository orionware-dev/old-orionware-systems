package core;

import java.util.HashSet;
import java.util.Set;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectInitialiser OrionObjectInitialiser;
    private Set<Object> librariesConfigurationSet;
    private Object libraryConfiguration;
    private Object configurationFacade;
    private Object annotationsRegistrationFacade;
    private Object annotationsProcessorFacade;
    
    
    public OrionObject()
    {
        this.librariesConfigurationSet = new HashSet<Object>();
        this.OrionObjectInitialiser = new OrionObjectInitialiser();
        this.libraryConfiguration = OrionObjectInitialiser.getLibraryConfigurationInstance();
        this.configurationFacade = OrionObjectInitialiser.getConfigurationFacadeInstance();
        this.annotationsRegistrationFacade = OrionObjectInitialiser.getAnnotationsRegistrationFacadeInstance();
        this.annotationsProcessorFacade = OrionObjectInitialiser.getAnnotationsProcessorFacadeInstance();
        initialiseCoreConfiguration();
        loadCoreConfiguration();
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private void initialiseCoreConfiguration()
    {
        libraryConfiguration = OrionObjectInitialiser.getInitialisedCoreConfiguration(libraryConfiguration);
    }
    
    
    private void loadCoreConfiguration()
    {
        registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    private void processAllLibrariesConfigurationIfItIsTheCoreLibrary()
    {
        if(thisIsCoreLibrary())
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    private boolean thisIsCoreLibrary()
    {
        return OrionObjectInitialiser.thisIsCoreLibrary(configurationFacade, getClass());
    }
    
    
    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        OrionObjectInitialiser.processAllLibrariesConfiguration(configurationFacade, librariesConfigurationSet);
        OrionObjectInitialiser.registerLibrariesAnnotations(annotationsRegistrationFacade, librariesConfigurationSet);
        OrionObjectInitialiser.processAllAnnotations(annotationsProcessorFacade, this);
    }
    
    
    protected void registerLibraryConfiguration(Object libraryConfiguration)
    {
        librariesConfigurationSet.add(libraryConfiguration);
    }
}