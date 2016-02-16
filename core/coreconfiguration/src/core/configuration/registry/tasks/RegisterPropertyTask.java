package core.configuration.registry.tasks;

import core.OrionSimpleObject;
import core.configuration.OrionConfigurationTask;
import core.configuration.registry.ConfigurationRegistry;

public class RegisterPropertyTask extends OrionSimpleObject implements OrionConfigurationTask
{
    public void run(String key, String value)
    {
        ConfigurationRegistry.registerProp(key, value);
    }
}