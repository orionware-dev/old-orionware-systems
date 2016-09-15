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
        return new HavePropertiesBeenRegisteredForLibraryTask().run(libraryClassPath);
    }


    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return new HavePropertiesBeenRegisteredForLibraryTask().run(libraryConfiguration.getLibraryClassPath());
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
        return new HaveConfigurationBeenRegisteredForLibraryTask().run(libraryClassPath);
    }


    @Override
    public boolean haveConfigurationBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return new HaveConfigurationBeenRegisteredForLibraryTask().run(libraryConfiguration.getLibraryClassPath());
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
        new SetPropertiesAsRegisteredForLibraryTask().run(libraryClassPath);
    }


    @Override
    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        new SetPropertiesAsRegisteredForLibraryTask().run(libraryConfiguration.getLibraryClassPath());
    }
    
    
    @Override
    public void setConfigurationAsRegisteredForLibrary(String libraryClassPath)
    {
        new SetConfigurationAsRegisteredForLibraryTask().run(libraryClassPath);
    }


    @Override
    public void setConfigurationAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        new SetConfigurationAsRegisteredForLibraryTask().run(libraryConfiguration.getLibraryClassPath());
    }


    @Override
    public void registerProp(String key, String value)
    {
        new RegisterPropertyTask().run(key, value);
    }


    @Override
    public void registerProp(KeyValuePair<String, String> keyValuePair)
    {
        new RegisterPropertyTask().run(keyValuePair);
    }


    @Override
    public void updateProp(String key, String value)
    {
        new UpdatePropertyTask().run(key, value);
    }


    @Override
    public void updateProp(KeyValuePair<String, String> keyValuePair)
    {
        new UpdatePropertyTask().run(keyValuePair);
    }


    @Override
    public void deleteProp(String key)
    {
        new DeletePropertyTask().run(key);
    }
}