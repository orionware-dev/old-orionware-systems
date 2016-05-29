package core.configuration.facades.registry.impl;

import core.configuration.facades.ConfigurationFacadeObject;
import core.configuration.facades.registry.PropertiesRegistrationFacade;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.PropertiesRegistrationServiceImpl;

public class PropertiesRegistrationFacadeImpl extends ConfigurationFacadeObject implements PropertiesRegistrationFacade
{
    private PropertiesRegistrationService propertiesRegistrationService;
    
    
    public PropertiesRegistrationFacadeImpl()
    {
        this.propertiesRegistrationService = new PropertiesRegistrationServiceImpl();
    }
    
    
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName)
    {
        return propertiesRegistrationService.havePropertiesBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName)
    {
        return propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void setPropertiesAsRegisteredForLibrary(String libraryName)
    {
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryName);
    }

    
    @Override
    public void registerProp(String key, String value)
    {
        propertiesRegistrationService.registerProp(key, value);
    }

    
    @Override
    public void updateProp(String key, String value)
    {
        propertiesRegistrationService.updateProp(key, value);
    }

    
    @Override
    public void deleteProp(String key)
    {
        propertiesRegistrationService.deleteProp(key);
    }
}