package core.configuration.registry;

import core.services.OrionService;

public interface PropertiesRegistrationService extends OrionService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setPropertiesAsRegisteredForLibrary(String libraryName);
}