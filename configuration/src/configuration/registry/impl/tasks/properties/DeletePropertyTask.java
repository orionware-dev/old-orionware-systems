package configuration.registry.impl.tasks.properties;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;

public class DeletePropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run(String key)
    {
        ConfigurationRegistry.deleteProp(key);
    }
}