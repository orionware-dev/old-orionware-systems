package configuration.services.registry.impl.tasks;

import configuration.ConfigurationObject;
import configuration.ConfigurationTask;
import configuration.registry.ConfigurationRegistry;

public class DeletePropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(String key)
    {
        ConfigurationRegistry.deleteProp(key);
    }
}