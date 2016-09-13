package configuration.registry.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;
import core.tuples.KeyValuePair;

public class RegisterPropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }


    public void run(KeyValuePair<String, String> keyValuePair)
    {
        ConfigurationRegistry.registerProp(keyValuePair);
    }
}