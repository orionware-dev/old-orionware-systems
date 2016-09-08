package core.configuration.facades.registry.impl;

import core.configuration.LibraryConfiguration;
import core.configuration.facades.ConfigurationFacadeObject;
import core.configuration.facades.registry.PropertiesRegistrationFacade;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.PropertiesRegistrationServiceImpl;
import core.tuples.KeyValuePair;

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


    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return propertiesRegistrationService.havePropertiesBeenRegisteredForLibrary(libraryConfiguration);
    }


    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return propertiesRegistrationService.havePropertiesNotBeenRegisteredForLibrary(libraryConfiguration);
    }


    @Override
    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        propertiesRegistrationService.setPropertiesAsRegisteredForLibrary(libraryConfiguration);
    }


    @Override
    public void registerProp(KeyValuePair<String, String> keyValuePair)
    {
        propertiesRegistrationService.registerProp(keyValuePair);
    }


    @Override
    public void updateProp(KeyValuePair<String, String> keyValuePair)
    {
        propertiesRegistrationService.updateProp(keyValuePair);
    }
}