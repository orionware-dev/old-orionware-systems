package configuration.classpath.impl;

import java.util.List;
import configuration.ConfigurationEntries;
import configuration.ConfigurationEntry;
import configuration.ConfigurationServiceObject;
import configuration.classpath.ConfigurationClasspathService;
import configuration.classpath.impl.tasks.GetConfigurationEntriesAsListTask;
import configuration.classpath.impl.tasks.GetConfigurationEntriesTask;
import configuration.classpath.impl.tasks.IsCoreLibraryTask;
import configuration.classpath.impl.tasks.LoadLibrariesPropertiesTask;

public class ConfigurationClasspathServiceImpl extends ConfigurationServiceObject implements ConfigurationClasspathService
{
    // this method is accurate when it is called from a base object
    // like inside OrionObject.java or DataStructureObject.java
    @Override
    public boolean isCoreLibrary(Class<?> classBeingRun)
    {
        return new IsCoreLibraryTask().run(classBeingRun);
    }


    @Override
    public boolean isCoreLibrary(Object objectBeingRun)
    {
        return new IsCoreLibraryTask().run(objectBeingRun);
    }


    @Override
    public void loadLibrariesProperties()
    {
        new LoadLibrariesPropertiesTask().run();
    }


    @SuppressWarnings("rawtypes")
    @Override
    public ConfigurationEntries getConfigurationEntries()
    {
        return new GetConfigurationEntriesTask().run();
    }


    @Override
    public List<ConfigurationEntry<Object, Object>> getConfigurationEntriesAsList()
    {
        return new GetConfigurationEntriesAsListTask().run();
    }
}