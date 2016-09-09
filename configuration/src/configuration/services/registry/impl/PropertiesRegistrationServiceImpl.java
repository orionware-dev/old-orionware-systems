package configuration.services.registry.impl;

import configuration.LibraryConfiguration;
import configuration.services.ConfigurationServiceObject;
import configuration.services.registry.PropertiesRegistrationService;
import configuration.services.registry.impl.tasks.DeletePropertyTask;
import configuration.services.registry.impl.tasks.HaveConfigurationBeenRegisteredForLibraryTask;
import configuration.services.registry.impl.tasks.RegisterPropertyTask;
import configuration.services.registry.impl.tasks.SetConfigurationAsRegisteredForLibraryTask;
import configuration.services.registry.impl.tasks.UpdatePropertyTask;
import core.tuples.KeyValuePair;

public class PropertiesRegistrationServiceImpl extends ConfigurationServiceObject implements PropertiesRegistrationService
{
    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(String libraryName)
    {
        return new HaveConfigurationBeenRegisteredForLibraryTask().run(libraryName);
    }


    @Override
    public boolean havePropertiesBeenRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        return new HaveConfigurationBeenRegisteredForLibraryTask().run(libraryConfiguration.getLibraryName());
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
        new SetConfigurationAsRegisteredForLibraryTask().run(libraryName);
    }


    @Override
    public void setPropertiesAsRegisteredForLibrary(LibraryConfiguration libraryConfiguration)
    {
        new SetConfigurationAsRegisteredForLibraryTask().run(libraryConfiguration.getLibraryName());
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