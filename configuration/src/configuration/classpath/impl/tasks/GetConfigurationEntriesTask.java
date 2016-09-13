package configuration.classpath.impl.tasks;

import configuration.ConfigurationEntries;
import configuration.ConfigurationObject;
import configuration.ConfigurationTask;

public class GetConfigurationEntriesTask extends ConfigurationObject implements ConfigurationTask
{
    public ConfigurationEntries<Object, Object> run()
    {
        return new ConfigurationEntries<Object, Object>(new GetConfigurationEntriesAsListTask().run());
    }
}