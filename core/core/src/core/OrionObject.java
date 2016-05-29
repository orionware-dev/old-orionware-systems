package core;

import java.util.HashSet;
import java.util.Set;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectInitialiser OrionObjectInitialiser;
    private Set<Object> librariesConfigurationSet;
    
    
    public OrionObject()
    {
        this.librariesConfigurationSet = new HashSet<Object>();
        this.OrionObjectInitialiser = new OrionObjectInitialiser();
        loadCoreConfiguration(OrionObjectInitialiser.getInitialisedCoreConfiguration());
        processAllLibrariesConfigurationIfItIsTheCoreLibrary();
    }
    
    
    private void loadCoreConfiguration(Object libraryConfiguration)
    {
        registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    //if the original class that was executed belongs to
    //the core projects then we explicitly call the
    //configuration processor. Otherwise the processor
    //is called by the OrionObject subclasses directly
    //so that all the libraries that have objects
    //that extend OrionObject will be configured
    private void processAllLibrariesConfigurationIfItIsTheCoreLibrary()
    {
        if(thisIsCoreLibrary())
        {
            processAllLibrariesConfiguration();
        }
    }
    
    
    private boolean thisIsCoreLibrary()
    {
        return OrionObjectInitialiser.thisIsCoreLibrary(getClass());
    }
    
    
    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        OrionObjectInitialiser.loadLibrariesProperties(librariesConfigurationSet);
        OrionObjectInitialiser.registerLibrariesAnnotations(librariesConfigurationSet);
        OrionObjectInitialiser.processAllAnnotations(this);
    }
    
    
    protected void registerLibraryConfiguration(Object libraryConfiguration)
    {
        librariesConfigurationSet.add(libraryConfiguration);
    }
}