package configuration;

import java.util.List;
import core.OrionSimpleObject;
import core.abstraction.OrionCollection;

public class ConfigurationEntries<T1, T2> extends OrionSimpleObject implements OrionCollection
{
    private List<ConfigurationEntry<T1, T2>> configurationEntries;


    public ConfigurationEntries()
    {

    }


    public ConfigurationEntries(List<ConfigurationEntry<T1, T2>> configurationEntries)
    {
        setConfigurationEntries(configurationEntries);
    }


    public List<ConfigurationEntry<T1, T2>> getConfigurationEntries()
    {
        return this.configurationEntries;
    }


    public void setConfigurationEntries(List<ConfigurationEntry<T1, T2>> configurationEntries)
    {
        this.configurationEntries = configurationEntries;
    }
}