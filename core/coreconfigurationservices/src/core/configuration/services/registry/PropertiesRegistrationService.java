package core.configuration.services.registry;

import core.configuration.ConfigurationService;

public interface PropertiesRegistrationService extends ConfigurationService
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setPropertiesAsRegisteredForLibrary(String libraryName);
    
    
    public void registerProp(String key, String value);
    
    
    public void updateProp(String key, String value);
    
    
    public void deleteProp(String key);
}