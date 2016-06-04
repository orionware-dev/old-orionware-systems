package core.objects;

import core.OrionSimpleObject;
import core.configuration.LibrariesConfiguration;
import core.configuration.LibraryConfiguration;

public abstract class OrionObject extends OrionSimpleObject
{
    private OrionObjectProcessor OrionObjectProcessor;
    
    
    public OrionObject()
    {
        OrionObjectProcessor = new OrionObjectProcessor(this);
    }
    
    
    //the libraryConfiguration method parameter is defined
    //in a library other than the core, like DataStructuresObject.java
    protected void registerLibraryConfiguration(LibraryConfiguration libraryConfiguration)
    {
        LibrariesConfiguration.registerLibraryConfiguration(libraryConfiguration);
    }
    
    
    //If a library other than the core is running like datastructures,
    //then this method is called so that all the libraries configs are loaded in one go
    protected void processAllLibrariesConfiguration()
    {
        OrionObjectProcessor.processAllLibrariesConfiguration(this);
    }
}