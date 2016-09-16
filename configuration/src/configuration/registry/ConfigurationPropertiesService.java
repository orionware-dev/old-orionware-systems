package configuration.registry;

import configuration.ConfigurationService;

public interface ConfigurationPropertiesService extends ConfigurationService
{
    public String getProp(String key);
}