package core.configuration.registry.tasks;

import core.OrionSimpleObject;
import core.configuration.ConfigurationObject;
import core.configuration.OrionConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class DeletePropertyTask extends ConfigurationObject implements OrionConfigurationTask
{
    public void run(String key)
    {
        ConfigurationRegistry.deleteProp(key);
    }
}