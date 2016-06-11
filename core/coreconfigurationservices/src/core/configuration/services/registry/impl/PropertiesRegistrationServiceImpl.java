package core.configuration.services.registry.impl;

import core.configuration.LibraryConfiguration;
import core.configuration.OrionProperties;
import core.configuration.services.ConfigurationServiceObject;
import core.configuration.services.registry.PropertiesRegistrationService;
import core.configuration.services.registry.impl.tasks.DeletePropertyTask;
import core.configuration.services.registry.impl.tasks.HaveConfigurationBeenRegisteredForLibraryTask;
import core.configuration.services.registry.impl.tasks.RegisterPropertyTask;
import core.configuration.services.registry.impl.tasks.SetConfigurationAsRegisteredForLibraryTask;
import core.configuration.services.registry.impl.tasks.UpdatePropertyTask;
import core.tuples.KeyValuePair;

public class PropertiesRegistrationServiceImpl extends ConfigurationServiceObject implements PropertiesRegistrationService
{
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName)
    {
        return HaveConfigurationBeenRegisteredForLibraryTask.run(libraryName);
    }
    
    
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return HaveConfigurationBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryName());
    }

    
    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryName)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryName);
    }
    
    
    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryConfiguration);
    }

    
    @Override
    public void setPropertiesAsRegisteredForLibrary(String libraryName)
    {
        SetConfigurationAsRegisteredForLibraryTask.run(libraryName);
    }
    
    
    @Override
    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        SetConfigurationAsRegisteredForLibraryTask.run(libraryConfiguration.getLibraryName());
    }
    
    
    @Override
    public void registerProp(String key, String value)
    {
        RegisterPropertyTask.run(key, value);
    }
    
    
    @Override
    public void registerProp(KeyValuePair<String, String> keyValuePair)
    {
        RegisterPropertyTask.run(keyValuePair);
    }
    
    
    @Override
    public void updateProp(String key, String value)
    {
        UpdatePropertyTask.run(key, value);
    }
    
    
    @Override
    public void updateProp(KeyValuePair<String, String> keyValuePair)
    {
        UpdatePropertyTask.run(keyValuePair);
    }
    
    
    @Override
    public void deleteProp(String key)
    {
        DeletePropertyTask.run(key);
    }
}