package core.configuration.services.classpath.impl.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import core.configuration.ConfigurationEntries;
import core.configuration.ConfigurationEntry;
import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.OrionProperties;
import core.configuration.registry.ConfigurationRegistry;

public class GetConfigurationEntriesTask extends ConfigurationObject implements ConfigurationTask
{
    public ConfigurationEntries<Object, Object> run()
    {
        OrionProperties allOrionProperties = ConfigurationRegistry.getProps();
        List<ConfigurationEntry<Object, Object>> configurationEntriesList = new ArrayList<ConfigurationEntry<Object, Object>>(allOrionProperties.size());
        ConfigurationEntries<Object, Object> configurationEntries = new ConfigurationEntries<Object, Object>(configurationEntriesList);

        if(allOrionProperties.isNotEmpty())
        {
            for(Entry<Object, Object> configurationEntry : allOrionProperties.entrySet())
            {
                ConfigurationEntry<Object, Object> newConfigurationEntry = new ConfigurationEntry<Object, Object>();
                newConfigurationEntry.setKey(configurationEntry.getKey());
                newConfigurationEntry.setValue(configurationEntry.getValue());
                configurationEntriesList.add(newConfigurationEntry);
            }
        }

        return configurationEntries;
    }
}