package configuration.registry.impl;

import configuration.ConfigurationServiceObject;
import configuration.LibraryConfiguration;
import configuration.registry.PropertiesRegistrationService;
import configuration.registry.impl.tasks.DeletePropertyTask;
import configuration.registry.impl.tasks.HaveConfigurationBeenRegisteredForLibraryTask;
import configuration.registry.impl.tasks.HavePropertiesBeenRegisteredForLibraryTask;
import configuration.registry.impl.tasks.RegisterPropertyTask;
import configuration.registry.impl.tasks.SetConfigurationAsRegisteredForLibraryTask;
import configuration.registry.impl.tasks.SetPropertiesAsRegisteredForLibraryTask;
import configuration.registry.impl.tasks.UpdatePropertyTask;
import core.tuples.KeyValuePair;

public class PropertiesRegistrationServiceImpl extends ConfigurationServiceObject implements PropertiesRegistrationService
{
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryClassPath)
    {
        return HavePropertiesBeenRegisteredForLibraryTask.run(libraryClassPath);
    }


    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return HavePropertiesBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryClassPath());
    }


    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(String libraryClassPath)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryClassPath);
    }


    @Override
    public boolean havePropertiesNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryConfiguration);
    }
    
    
    @Override
    public boolean haveConfigurationBeenRegisteredForLibrary(String libraryClassPath)
    {
        return HaveConfigurationBeenRegisteredForLibraryTask.run(libraryClassPath);
    }


    @Override
    public boolean haveConfigurationBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return HaveConfigurationBeenRegisteredForLibraryTask.run(libraryConfiguration.getLibraryClassPath());
    }


    @Override
    public boolean haveConfigurationNotBeenRegisteredForLibrary(String libraryClassPath)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryClassPath);
    }


    @Override
    public boolean haveConfigurationNotBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return !havePropertiesBeenRegisteredForLibrary(libraryConfiguration);
    }


    @Override
    public void setPropertiesAsRegisteredForLibrary(String libraryClassPath)
    {
        SetPropertiesAsRegisteredForLibraryTask.run(libraryClassPath);
    }


    @Override
    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        SetPropertiesAsRegisteredForLibraryTask.run(libraryConfiguration.getLibraryClassPath());
    }
    
    
    @Override
    public void setConfigurationAsRegisteredForLibrary(String libraryClassPath)
    {
        SetConfigurationAsRegisteredForLibraryTask.run(libraryClassPath);
    }


    @Override
    public void setConfigurationAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        SetConfigurationAsRegisteredForLibraryTask.run(libraryConfiguration.getLibraryClassPath());
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