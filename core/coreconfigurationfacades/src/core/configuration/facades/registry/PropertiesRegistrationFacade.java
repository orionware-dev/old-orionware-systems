package core.configuration.facades.registry;

import core.configuration.ConfigurationFacade;
import core.services.OrionFacade;

public interface PropertiesRegistrationFacade extends ConfigurationFacade
{
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName);
    
    
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName);
    
    
    public void setPropertiesAsRegisteredForLibrary(String libraryName);
    
    
    public void registerProp(String key, String value);
    
    
    public void updateProp(String key, String value);
    
    
    public void deleteProp(String key);
}