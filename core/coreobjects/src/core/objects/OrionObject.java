package core.objects;

import configuration.LibrariesConfiguration;
import configuration.LibraryConfiguration;
import core.OrionSimpleObject;
import core.objects.services.orionobject.OrionObjectProcessorService;
import core.objects.services.orionobject.impl.OrionObjectProcessorServiceImpl;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectProcessorService orionObjectProcessorService;


    public OrionObject()
    {
        this.orionObjectProcessorService = new OrionObjectProcessorServiceImpl(this);
    }


    //the method parameter is passed by subclasses and it is
    //the location and name of the Enum configuration class that exists
    //in a library other than the core, like
    //DataStructuresConfigurationEnumeration.java
    //and its class is passed by the library's main object like
    //DataStructuresObject.java
    protected void registerLibraryConfiguration(String libraryConfigurationEnumerationClassPath)
    {
        if(!LibrariesConfiguration.getLibrariesConfigurationEnumerationClassPaths().contains(libraryConfigurationEnumerationClassPath))
        {
            LibraryConfiguration libraryConfiguration = orionObjectProcessorService.convertConfigurationEnumerationToLibraryConfiguration(libraryConfigurationEnumerationClassPath);
            LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
            LibrariesConfiguration.registerLibraryConfigurationEnumerationClassPath(libraryConfigurationEnumerationClassPath);
        }
    }


    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded
    //in one go
    protected void processAllLibrariesConfiguration()
    {
        orionObjectProcessorService.processAllLibrariesConfiguration(this);
    }
}