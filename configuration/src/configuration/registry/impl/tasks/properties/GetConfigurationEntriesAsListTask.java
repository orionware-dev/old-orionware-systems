package configuration.registry.impl.tasks.properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import configuration.ConfigurationEntry;
import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.OrionProperties;
import configuration.registry.ConfigurationRegistry;

public class GetConfigurationEntriesAsListTask extends ConfigurationObject implements ConfigurationTask
{
    public static List<ConfigurationEntry<Object, Object>> run()
    {
        OrionProperties allOrionProperties = ConfigurationRegistry.getProps();
        List<ConfigurationEntry<Object, Object>> configurationEntries = new ArrayList<ConfigurationEntry<Object, Object>>(allOrionProperties.size());

        if(allOrionProperties.isNotEmpty())
        {
            for(Entry<Object, Object> configurationEntry : allOrionProperties.entrySet())
            {
                ConfigurationEntry<Object, Object> newConfigurationEntry = new ConfigurationEntry<Object, Object>();
                newConfigurationEntry.setKey(configurationEntry.getKey());
                newConfigurationEntry.setValue(configurationEntry.getValue());
                configurationEntries.add(newConfigurationEntry);
            }
        }

        return configurationEntries;
    }
}