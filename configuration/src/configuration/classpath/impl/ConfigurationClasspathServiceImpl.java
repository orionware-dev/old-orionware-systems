package configuration.classpath.impl;

import java.util.List;
import configuration.ConfigurationEntries;
import configuration.ConfigurationEntry;
import configuration.ConfigurationServiceObject;
import configuration.classpath.ConfigurationClasspathService;
import configuration.classpath.impl.tasks.GetConfigurationEntriesAsListTask;
import configuration.classpath.impl.tasks.GetConfigurationEntriesTask;
import configuration.classpath.impl.tasks.LoadLibrariesPropertiesTask;

public class ConfigurationClasspathServiceImpl extends ConfigurationServiceObject implements ConfigurationClasspathService
{
    @Override
    public void loadLibrariesProperties()
    {
        LoadLibrariesPropertiesTask.run();
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