package core;

import core.initialisation.OrionInitialiserService;
import core.initialisation.OrionInitialiserServiceImpl;

public abstract class OrionObject
{
    private OrionInitialiserService orionInitialiserService = new OrionInitialiserServiceImpl();
    
    
    public OrionObject()
    {
        orionInitialiserService.initialiseOrionObject(this);
    }
    
    
    protected void registerLibraryConfiguration(Object libraryConfiguration)
    {
        orionInitialiserService.initialiseOrionObject(libraryConfiguration);
    }
    
    
    protected void processAllLibrariesConfiguration()
    {
        orionInitialiserService.processAllLibrariesConfiguration(this);
    }
}