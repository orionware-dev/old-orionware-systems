package core.objects;

import core.OrionSimpleObject;
import core.configuration.ConfigurationEnumeration;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;
import core.objects.services.orionobject.OrionObjectProcessorService;
import core.objects.services.orionobject.impl.OrionObjectProcessorServiceImpl;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectProcessorService orionObjectProcessorService;
    
    
    public OrionObject()
    {
        this.orionObjectProcessorService = new OrionObjectProcessorServiceImpl(this);
    }
    
    
    //the libraryConfiguration method parameter is defined
    //in a library other than the core, like DataStructuresObject.java
    protected void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        LibraryConfiguration libraryConfiguration = orionObjectProcessorService.convertConfigurationEnumerationToLibraryConfiguration(libraryConfigurationEnumerationClassPath);
        LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        orionObjectProcessorService.processAllLibrariesConfiguration(this);
    }
}