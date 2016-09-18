package configuration.registry.impl;

import java.util.List;
import configuration.ConfigurationEntries;
import configuration.ConfigurationEntry;
import configuration.ConfigurationServiceObject;
import configuration.LibraryConfiguration;
import configuration.registry.ConfigurationRegistryService;
import configuration.registry.impl.tasks.libraries.HaveConfigurationBeenRegisteredForLibraryTask;
import configuration.registry.impl.tasks.libraries.HavePropertiesBeenRegisteredForLibraryTask;
import configuration.registry.impl.tasks.libraries.LoadLibrariesPropertiesTask;
import configuration.registry.impl.tasks.libraries.LoadLibraryPropertiesTask;
import configuration.registry.impl.tasks.libraries.SetConfigurationAsRegisteredForLibraryTask;
import configuration.registry.impl.tasks.libraries.SetPropertiesAsRegisteredForLibraryTask;
import configuration.registry.impl.tasks.properties.DeletePropertyTask;
import configuration.registry.impl.tasks.properties.GetConfigurationEntriesAsListTask;
import configuration.registry.impl.tasks.properties.GetConfigurationEntriesTask;
import configuration.registry.impl.tasks.properties.GetPropertyTask;
import configuration.registry.impl.tasks.properties.RegisterPropertyTask;
import configuration.registry.impl.tasks.properties.UpdatePropertyTask;
import core.tuples.KeyValuePair;

public class ConfigurationRegistryServiceImpl extends ConfigurationServiceObject implements ConfigurationRegistryService
{
    @Override
    public void run(LibraryConfiguration libraryConfiguration)
    {
        LoadLibraryPropertiesTask.run(libraryConfiguration);
    }
    
    
    @Override
    public void loadLibrariesProperties()
    {
        LoadLibrariesPropertiesTask.run();
    }
    
    
    @Override
    public String getProp(String key)
    {
        return GetPropertyTask.run(key);
    }
    
    
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
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public ConfigurationEntries getConfigurationEntries()
    {
        return GetConfigurationEntriesTask.run();
    }


    @Override
    public List<ConfigurationEntry<Object, Object>> getConfigurationEntriesAsList()
    {
        return GetConfigurationEntriesAsListTask.run();
    }
}