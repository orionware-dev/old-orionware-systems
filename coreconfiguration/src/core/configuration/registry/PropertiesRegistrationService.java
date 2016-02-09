package core.configuration.registry;

import core.configuration.OrionConfigurationService;

public interface PropertiesRegistrationService extends OrionConfigurationService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setPropertiesAsRegisteredForLibrary(String libraryName);
}