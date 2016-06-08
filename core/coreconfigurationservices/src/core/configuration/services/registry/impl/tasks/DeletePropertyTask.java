package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class DeletePropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public static void run(String key)
    {
        ConfigurationRegistry.deleteProp(key);
    }
}