package configuration.registry.impl.tasks.properties;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;
import core.tuples.KeyValuePair;

public class RegisterPropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }


    public static void run(KeyValuePair<String, String> keyValuePair)
    {
        ConfigurationRegistry.registerProp(keyValuePair);
    }
}