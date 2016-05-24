package core;

import java.util.HashSet;
import java.util.Set;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectInitialiser OrionObjectInitialiser;
    private Set<Object> librariesConfigurationSet;
    private Object libraryConfiguration;
    private Object configurationService;
    private Object annotationsRegistrationService;
    private Object annotationsProcessorService;
    
    
    public OrionObject()
    {
        this.librariesConfigurationSet = new HashSet<Object>();
        this.OrionObjectInitialiser = new OrionObjectInitialiser();
        this.libraryConfiguration = OrionObjectInitialiser.getLibraryConfigurationInstance();
        this.configurationService = OrionObjectInitialiser.getConfigurationServiceInstance();
        this.annotationsRegistrationService = OrionObjectInitialiser.getAnnotationsRegistrationServiceInstance();
        this.annotationsProcessorService = OrionObjectInitialiser.getAnnotationsProcessorServiceInstance();
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
        return OrionObjectInitialiser.thisIsCoreLibrary(configurationService, getClass());
    }
    
    
    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        OrionObjectInitialiser.processAllLibrariesConfiguration(configurationService, librariesConfigurationSet);
        OrionObjectInitialiser.registerLibrariesAnnotations(annotationsRegistrationService, librariesConfigurationSet);
        OrionObjectInitialiser.processAllAnnotations(annotationsProcessorService, this);
    }
    
    
    protected void registerLibraryConfiguration(Object libraryConfiguration)
    {
        librariesConfigurationSet.add(libraryConfiguration);
    }
}