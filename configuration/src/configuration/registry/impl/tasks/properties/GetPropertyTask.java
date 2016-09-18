package configuration.registry.impl.tasks.properties;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;

public class GetPropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public static String run(String key)
    {
        return ConfigurationRegistry.getProp(key);
    }
}