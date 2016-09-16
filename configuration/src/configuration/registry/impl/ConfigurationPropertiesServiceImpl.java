package configuration.registry.impl;

import configuration.ConfigurationServiceObject;
import configuration.registry.ConfigurationPropertiesService;
import configuration.registry.impl.tasks.GetPropertyTask;

public class ConfigurationPropertiesServiceImpl extends ConfigurationServiceObject implements ConfigurationPropertiesService
{
    @Override
    public String getProp(String key)
    {
        return GetPropertyTask.run(key);
    }
}