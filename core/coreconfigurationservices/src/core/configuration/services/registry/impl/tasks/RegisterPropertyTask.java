package core.configuration.services.registry.impl.tasks;

import core.configuration.ConfigurationObject;
import core.configuration.ConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class RegisterPropertyTask extends ConfigurationObject implements ConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }
}