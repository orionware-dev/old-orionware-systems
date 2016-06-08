package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;
import core.tuples.KeyValuePair;

public class UpdatePropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public static synchronized void run(String key, String value)
    {
        ConfigurationRegistry.updateProp(key, value);
    }
    
    
    public static synchronized void run(KeyValuePair<String, String> keyValuePair)
    {
        ConfigurationRegistry.updateProp(keyValuePair);
    }
}