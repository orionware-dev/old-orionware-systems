package core.configuration.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.OrionConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class RegisterPropertyTask extends ConfigurationObject implements OrionConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }
}