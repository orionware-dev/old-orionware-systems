package core;

import java.util.HashSet;
import java.util.Set;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectInitialiser OrionObjectInitialiser;
    private Set<Object> librariesConfigurationSet = new HashSet<Object>();
    private Object libraryConfiguration;
    private Object configurationService;
    private Object annotationsRegistrationService;
    private Object annotationsProcessorService;
    
    
    public OrionObject()
    {
        OrionObjectInitialiser = new OrionObjectInitialiser();
        libraryConfiguration = OrionObjectInitialiser.instantiateLibraryConfiguration();
        configurationService = OrionObjectInitialiser.instantiateConfigurationService();
        annotationsRegistrationService = OrionObjectInitialiser.instantiateAnnotationsRegistrationService();
        annotationsProcessorService = OrionObjectInitialiser.instantiateAnnotationsProcessorService();
        initialiseCoreConfiguration();
        loadCoreConfiguration();
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private void initialiseCoreConfiguration()
    {
        libraryConfiguration = OrionObjectInitialiser.initialiseCoreConfiguration(libraryConfiguration);
    }
    
    
    private void loadCoreConfiguration()
    {
        registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    //this method is called by this constructor if only the core is running.
    //If another library is running like datastructures, then that constructor
    //will call this method so that all the libraries configs are loaded in one go
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