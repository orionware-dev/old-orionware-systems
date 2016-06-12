package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;
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