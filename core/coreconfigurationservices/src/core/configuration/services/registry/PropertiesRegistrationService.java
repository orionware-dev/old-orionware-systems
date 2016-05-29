package core.configuration.services.registry;

import core.configuration.OrionConfigurationService;

public interface PropertiesRegistrationService extends OrionConfigurationService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setPropertiesAsRegisteredForLibrary(String libraryName);
    
    
    public void registerProp(String key, String value);
    
    
    public void updateProp(String key, String value);
    
    
    public void deleteProp(String key);
}