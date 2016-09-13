package configuration.registry.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;
import core.tuples.KeyValuePair;

public class UpdatePropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.updateProp(key, value);
    }


    public void run(KeyValuePair<String, String> keyValuePair)
    {
        ConfigurationRegistry.updateProp(keyValuePair);
    }
}